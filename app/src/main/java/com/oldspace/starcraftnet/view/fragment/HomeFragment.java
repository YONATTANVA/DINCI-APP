package com.oldspace.starcraftnet.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oldspace.starcraftnet.Model.Incident;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.adapter.IncidentRecyclerView;

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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

        return view;
    }

    private ArrayList<Incident> builIncidents(){
        ArrayList<Incident> incidents = new ArrayList<Incident>();
        incidents.add(new Incident("","Semaforo malogrado","1 dia","Pendiente"));
        incidents.add(new Incident("","Pista en mal estado","2 dias","Pendiente"));
        incidents.add(new Incident("","Demasiada basura en el parque","3 dias","Atendido"));

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
