package com.oldspace.starcraftnet.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.oldspace.starcraftnet.R;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
    }
    public void registerIncident(View view){

        TextView name = (TextView) findViewById(R.id.name);
        TextView adress = (TextView) findViewById(R.id.adress);
        TextView detail = (TextView) findViewById(R.id.detail);
        Toast.makeText(getApplicationContext(),"Incidente registrado",Toast.LENGTH_LONG).show();
    }

}
