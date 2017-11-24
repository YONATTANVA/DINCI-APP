package com.oldspace.starcraftnet;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Citizen;
import com.oldspace.starcraftnet.helper.HelperApi;
import com.oldspace.starcraftnet.view.ContainerActivity;
import com.oldspace.starcraftnet.view.CreateAccountActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //evento para el login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Citizen citizen;
        final Activity activity = this;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText eUser = (TextInputEditText) findViewById(R.id.txtUserLogin);
                TextInputEditText ePassword = (TextInputEditText) findViewById(R.id.txtPasswordLogin);
                String user = eUser.getText().toString();
                String password = ePassword.getText().toString();
                HelperApi.login(user, password, activity);
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
