package com.oldspace.starcraftnet.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.LoginActivity;
import com.oldspace.starcraftnet.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);

        final TextInputEditText name = (TextInputEditText) findViewById(R.id.txtNameCitizen);
        final TextInputEditText pass = (TextInputEditText) findViewById(R.id.txtPasswordCitizen);
        final TextInputEditText dni = (TextInputEditText) findViewById(R.id.txtDniCitizen);
        final Button btnunete = (Button) findViewById(R.id.btnNewAccount);

        btnunete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String nom = name.getText().toString();
                final String clave = pass.getText().toString();
                final String dnii = dni.getText().toString();

                Response.Listener<String> responseListerner = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");
                            if (success){
                                Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                                CreateAccountActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                                builder.setMessage("Register Faild")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(nom,clave,dnii,responseListerner);
                RequestQueue queue = Volley.newRequestQueue(CreateAccountActivity.this);
                queue.add(registerRequest);


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
