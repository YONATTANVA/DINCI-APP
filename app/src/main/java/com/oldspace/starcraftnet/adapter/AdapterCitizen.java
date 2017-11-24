package com.oldspace.starcraftnet.adapter;

import android.content.Context;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Citizen;

import org.json.JSONArray;

/**
 * Created by YonattanVisita on 22/11/2017.
 */

public class AdapterCitizen {
    Citizen citizen = null;
    private RequestQueue requestQueue;
    JsonArrayRequest jsonRequest;
    private String url = "";

    public AdapterCitizen(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    public void login(String user, String password){
        url = "http://www.dinci.somee.com/api/citizen/GetAllCitizenLogin/?user=" + user + "&password=" + password;
        jsonRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

    }
}
