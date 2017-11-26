package com.oldspace.starcraftnet.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oldspace.starcraftnet.LoginActivity;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.adapter.IncidentAdapter;
import com.oldspace.starcraftnet.controller.DinciSingleton;
import com.oldspace.starcraftnet.model.Incident;

import java.util.HashMap;

public class NewIncidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_incident);

        showToolbar("Nuevo Incidente",true);







        //metod
        final IncidentAdapter incidentAdapter = new IncidentAdapter(this);
        Button btnNewIncident = (Button) findViewById(R.id.btnAddIncident);
        btnNewIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tType = (TextView) findViewById(R.id.txtTypeIncident);
                TextView tPlace = (TextView) findViewById(R.id.txtPlace);
                TextView tDetail = (TextView) findViewById(R.id.txtDetail);

                String image ="http://4.bp.blogspot.com/_u3ZcZnSYQw4/TLhahDj6_7I/AAAAAAAAAA0/gLQrOCMTyAQ/s1600/basura1%5B1%5D.jpg";
                String type = tType.getText().toString();
                String place = tPlace.getText().toString();
                String detail = tDetail.getText().toString();

                Incident incident = new Incident(image,type,place,detail,0);
                incidentAdapter.addNewIncident(incident);
            }
        });
    }


    //metodo que muestra el toolbar
    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
