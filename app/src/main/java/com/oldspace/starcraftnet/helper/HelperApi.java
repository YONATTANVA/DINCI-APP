package com.oldspace.starcraftnet.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Citizen;
import com.oldspace.starcraftnet.view.ContainerActivity;
import com.oldspace.starcraftnet.view.CreateAccountActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by YonattanVisita on 22/11/2017.
 */

public class HelperApi {

    public static void login (String user, String password ,final Activity context){

        // instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://www.dinci.somee.com/api/citizen/GetAllCitizenLogin/?user=" + user + "&password=" + password;
        // request a string response asynchronously from the provided URL
        JsonArrayRequest JsonRequest = new JsonArrayRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() >= 1){
                            Intent intent = new Intent(context,ContainerActivity.class);
                            context.startActivity(intent);
                        }else {
                            Toast.makeText(context,"Usuario no registrado. Porfavor registrese.",Toast.LENGTH_LONG).show();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"no funciono",Toast.LENGTH_SHORT).show();
            }
        });
        // add the request to the RequestQueue
        queue.add(JsonRequest);
    }

    public static void createNewAccount (Citizen citizen, final Activity context){

        // instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://www.dinci.somee.com/api/citizen/AddCitizen";
        // request a string response asynchronously from the provided URL
        JsonArrayRequest JsonRequest = new JsonArrayRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() >= 1){
                            Intent intent = new Intent(context,ContainerActivity.class);
                            context.startActivity(intent);
                        }else {
                            Toast.makeText(context,"Usuario no registrado. Porfavor registrese.",Toast.LENGTH_LONG).show();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"no funciono",Toast.LENGTH_SHORT).show();
            }
        });
        // add the request to the RequestQueue
        queue.add(JsonRequest);
    }
}
