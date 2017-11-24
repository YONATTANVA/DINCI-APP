package com.oldspace.starcraftnet.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Citizen;
import com.oldspace.starcraftnet.view.ContainerActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by YonattanVisita on 22/11/2017.
 */

public class AdapterCitizen {
    Citizen citizen = null;
    private RequestQueue requestQueue;
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
    private String url = "";
    Context context;

    public AdapterCitizen(Context context){
        this.context = context;

        //Creando una nueva cola de peticiones
        this.requestQueue = Volley.newRequestQueue(context);
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

        requestQueue.add(jsonArrayRequest);

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
                        if(response == "true"){
                            Intent intent = new Intent(context.getApplicationContext(),ContainerActivity.class);
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
        requestQueue.add(stringRequest);
    }
}
