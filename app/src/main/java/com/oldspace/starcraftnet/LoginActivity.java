package com.oldspace.starcraftnet;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.oldspace.starcraftnet.adapter.AdapterCitizen;
import com.oldspace.starcraftnet.view.CreateAccountActivity;




public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AdapterCitizen adapterCitizen = new AdapterCitizen(this);

        //evento para el login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText eUser = (TextInputEditText) findViewById(R.id.txtUserLogin);
                TextInputEditText ePassword = (TextInputEditText) findViewById(R.id.txtPasswordLogin);
                String user = eUser.getText().toString();
                String password = ePassword.getText().toString();
                adapterCitizen.login(user,password);
            }
        });

        //evento para crear nuevo usuario
        TextView txtNewUser = (TextView) findViewById(R.id.newAccount);
        txtNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateNewAccount();
            }
        });

    }

    private void goCreateNewAccount(){
        Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
        startActivity(intent);
    }

  }
