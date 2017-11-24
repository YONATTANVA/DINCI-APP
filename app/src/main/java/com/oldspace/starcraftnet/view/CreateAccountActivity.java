package com.oldspace.starcraftnet.view;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.model.Citizen;

import com.oldspace.starcraftnet.adapter.AdapterCitizen;

public class CreateAccountActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);

        //Evento crear nuevo usuario
        final AdapterCitizen adapterCitizen = new AdapterCitizen(this);
        Button btnNewAccount = (Button) findViewById(R.id.btnNewAccount);
        btnNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextInputEditText tName = (TextInputEditText) findViewById(R.id.txtNameCitizen);
                final TextInputEditText tPass = (TextInputEditText) findViewById(R.id.txtPasswordCitizen);
                final TextInputEditText tDni = (TextInputEditText) findViewById(R.id.txtDniCitizen);
                final String nameCitizen = tName.getText().toString();
                final String passwordCitizen = tPass.getText().toString();
                final String dniCitizen = tDni.getText().toString();
                final Citizen citizen = new Citizen(0,nameCitizen,passwordCitizen,dniCitizen,null);

                adapterCitizen.createNewAccount(citizen);

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
