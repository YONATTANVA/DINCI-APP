package com.oldspace.starcraftnet.view.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Incident;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.adapter.IncidentRecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home", false, view);

        RecyclerView incidentsRecyclerView = (RecyclerView) view.findViewById(R.id.incidentRecyclerView);

        //creando un layoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //creando un adapter
        IncidentRecyclerView adapter = new IncidentRecyclerView(builIncidents(),R.layout.view_cardview,getActivity());

        //agregando el layout y adaptador al recycler
        incidentsRecyclerView.setLayoutManager(linearLayoutManager);
        incidentsRecyclerView.setAdapter(adapter);



        //agregar nuevo incidente
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.addButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instantiate the RequestQueue
                RequestQueue queue = Volley.newRequestQueue(v.getContext());
                String url ="https://postman-echo.com/ip";

// request a string response asynchronously from the provided URL
                JsonObjectRequest JsonRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Toast.makeText(view.getContext(),response.getString("ip"),Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(view.getContext(),"no funciono",Toast.LENGTH_SHORT).show();
                    }
                });

// add the request to the RequestQueue
                queue.add(JsonRequest);
            }
        });

        return view;
    }

    private ArrayList<Incident> builIncidents(){
        ArrayList<Incident> incidents = new ArrayList<Incident>();
        incidents.add(new Incident("http://www.chimbotenlinea.com/sites/default/files/styles/grande/public/field/image/semaforos-malogrados_0.jpg?itok=4UbjQeZ5","Semaforo malogrado","1 dia","Pendiente"));
        incidents.add(new Incident("http://cde.elcomercio.pe/66/ima/0/0/4/1/2/412676.jpg","Pista en mal estado","2 dias","Pendiente"));
        incidents.add(new Incident("http://www.eluniversaldf.mx/fotos/grandebasuraparke.jpg","Demasiada basura en el parque","3 dias","Atendido"));

        return incidents;
    }

    public void showToolbar(String title, boolean buttonUp, View view){
        Toolbar toolbar =  view.findViewById(R.id.toolbar);
        //se obtiene el fragment y se combiente al tipo de su conteiner
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(buttonUp);

    }

}
