package com.oldspace.starcraftnet.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.controller.DinciSingleton;
import com.oldspace.starcraftnet.model.Incident;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by YonattanVisita on 25/11/2017.
 */

public class IncidentAdapter {

    private Incident incident = null;
    private List<Incident> items;
    JsonArrayRequest jsonArrayRequest ;
    StringRequest stringRequest;
    JsonObjectRequest jsonObjectRequest;
    private Context context = null;
    private String url;
    private int idCitizen = 0;
    JSONArray jsonArray = new JSONArray();

    public IncidentAdapter(Context context){
        this.context = context;
        this.idCitizen = setIdCitizen();

    }

    private int setIdCitizen(){
        if(CitizenAdapter.idCitizen != 0){
            this.idCitizen = CitizenAdapter.idCitizen;
        }
        return  this.idCitizen;
    }

    public void getIncidentsByApi(final View view){



        url = "http://www.dinci.somee.com/api/incident/getallincidentxuser/" + this.idCitizen;



        jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        items = parseJson(response);

                        Toast.makeText(context,"pasoOOO con " + items.size() + " items",Toast.LENGTH_LONG).show();
                        if(items.size() > 0){
                            showRecyclerView(view, items);
                        }

                        //Toast.makeText(context,"FinalizoOOO",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"Error: " + error.toString(),Toast.LENGTH_LONG).show();
                    }
                }

        );
        DinciSingleton.getIntance(context).addToRequestQueue(jsonArrayRequest);
    }

    public List<Incident> parseJson(JSONArray jsonArray){
        List<Incident> incidents = new ArrayList();
        JSONObject jsonObject = null;
        for (int i = 0; i < jsonArray.length(); i++){
            try {
                jsonObject = jsonArray.getJSONObject(i);
                String image = "http://4.bp.blogspot.com/_u3ZcZnSYQw4/TLhahDj6_7I/AAAAAAAAAA0/gLQrOCMTyAQ/s1600/basura1%5B1%5D.jpg";
                String name = jsonObject.getString("descriptionIncidentType");
                String time = jsonObject.getString("timpoTranscurridoIncident");
                String solution = jsonObject.getString("descriptionStatus");
                incidents.add(new Incident(image,name,time,solution,idCitizen));
            } catch (JSONException e) {
                Log.e("JsonObjet", "Se ha producido al crear la lista de incidentes. "+ e.getMessage());
            }
        }
        return incidents;
    }


    public void addNewIncident(final Incident incident){


        url = "http://www.dinci.somee.com/api/incident/AddIncident";
        stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(Boolean.parseBoolean(response)){
                            Toast.makeText(context,"Agregado",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("addNewIncident", "Se ha producido al crear lun nuevo incidente. "+ error.getMessage());
                    }
                }
        ){
            @Override
            public HashMap<String, String> getParams(){
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("idIncidentType",incident.getType());
                parameters.put("ubicationIncident",incident.getPlace());
                parameters.put("ubicationIncident",incident.getDetail());
                parameters.put("idCitizen",String.valueOf(idCitizen));
                parameters.put("idEmployee",String.valueOf(0));

                return parameters;
            }
        };

        DinciSingleton.getIntance(context).addToRequestQueue(stringRequest);
    }

    public void getDetailIncident(){
        url = "";
        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"Error :" + error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        DinciSingleton.getIntance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void showRecyclerView(View view, List<Incident> incidents){
        RecyclerView incidentsRecyclerView = (RecyclerView) view.findViewById(R.id.incidentRecyclerView);

        //creando un layoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //creando un adapter
        IncidentRecyclerViewAdapter adapter = new IncidentRecyclerViewAdapter(incidents,R.layout.view_cardview,context);

        //agregando el layout y adaptador al recycler
        incidentsRecyclerView.setLayoutManager(linearLayoutManager);
        incidentsRecyclerView.setAdapter(adapter);

    }

}
