package com.oldspace.starcraftnet.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.pojos.Citizen;

import org.json.JSONObject;

import java.io.InputStream;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
    }


    //metodo que muestra el toolbar
    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public Citizen newCitizen(){
        TextView name = (TextView) findViewById(R.id.name);
        TextView password = (TextView) findViewById(R.id.password);
        TextView phoneNumber = (TextView) findViewById(R.id.phoneNumber);

        Citizen citizen= new Citizen(0,name.getText().toString(),password.getText().toString(),phoneNumber.getText().toString(),null);
        return  citizen;
    }



}
