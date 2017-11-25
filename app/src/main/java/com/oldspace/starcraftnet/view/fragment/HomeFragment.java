package com.oldspace.starcraftnet.view.fragment;


import android.content.Intent;
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

import com.oldspace.starcraftnet.adapter.IncidentAdapter;
import com.oldspace.starcraftnet.model.Incident;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.adapter.IncidentRecyclerViewAdapter;
import com.oldspace.starcraftnet.view.CardViewDetailActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        IncidentAdapter incidentAdapter = new IncidentAdapter(container.getContext());
        /*ArrayList<Incident> incidents = new ArrayList<>();
        incidents = incidentAdapter.getIncidents();*/

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home", false, view);

        RecyclerView incidentsRecyclerView = (RecyclerView) view.findViewById(R.id.incidentRecyclerView);

        /*//creando un layoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //creando un adapter
        IncidentRecyclerViewAdapter adapter = new IncidentRecyclerViewAdapter(incidents,R.layout.view_cardview,getActivity());

        //agregando el layout y adaptador al recycler
        incidentsRecyclerView.setLayoutManager(linearLayoutManager);
        incidentsRecyclerView.setAdapter(adapter);
*/


        //agregar nuevo incidente
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.addButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CardViewDetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void showToolbar(String title, boolean buttonUp, View view){
        Toolbar toolbar =  view.findViewById(R.id.toolbar);
        //se obtiene el fragment y se combiente al tipo de su conteiner
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(buttonUp);

    }

}
