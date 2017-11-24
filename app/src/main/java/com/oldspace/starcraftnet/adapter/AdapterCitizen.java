package com.oldspace.starcraftnet.adapter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.LoginActivity;
import com.oldspace.starcraftnet.controller.DinciSingleton;
import com.oldspace.starcraftnet.model.Citizen;
import com.oldspace.starcraftnet.view.ContainerActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by YonattanVisita on 22/11/2017.
 */

public class AdapterCitizen {
    private int idCitizen;
    //private RequestQueue requestQueue; AHORA SE USA SINGLETON
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
    private String url = "";
    Context context;

    public AdapterCitizen(Context context){
        this.context = context;
        //Creando una nueva cola de peticiones, ACTUALIZADO: AHORA SE USA SINGLETON
        //this.requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    private final void setIdCitizen(JSONArray jsonArray){
        for(int i = 0 ; i < jsonArray.length(); i++){
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject = jsonArray.getJSONObject(i);
                idCitizen = jsonObject.getInt("idCitizen");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    private int getIdCitizen(){
        return this.idCitizen;
    }

    public void login(String user, String password){
        url = "http://www.dinci.somee.com/api/citizen/GetAllCitizenLogin/?user=" + user + "&password=" + password;
        jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() == 1){
                            setIdCitizen(response);
                            Toast.makeText(context,"id del usuario" + getIdCitizen() ,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context.getApplicationContext(), ContainerActivity.class);
                            context.startActivity(intent);
                        }else{
                            Toast.makeText(context,"Usuario no registrado",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"Error : " + error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );

        DinciSingleton.getIntance(context).addToRequestQueue(jsonArrayRequest);

    }

    public void createNewAccount(final Citizen citizen){

        url = "http://www.dinci.somee.com/api/citizen/AddCitizen";
        //Toast.makeText(context,citizen.getName(),Toast.LENGTH_SHORT).show();
        stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                        if(Boolean.parseBoolean(response)){
                            Intent intent = new Intent(context.getApplicationContext(),LoginActivity.class);
                            context.startActivity(intent);
                        }else {
                            Toast.makeText(context,"Este usuario ya existe.",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"Error :" + error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected HashMap<String, String> getParams(){
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("nameCitizen",citizen.getName());
                parameters.put("passwordCitizen",citizen.getPassword());
                parameters.put("phonenumberCitizen",citizen.getDni());
                return parameters;
            }
        };
        DinciSingleton.getIntance(context).addToRequestQueue(stringRequest);
    }
}
