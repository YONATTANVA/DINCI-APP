package com.oldspace.starcraftnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.oldspace.starcraftnet.view.ContainerActivity;
import com.oldspace.starcraftnet.view.CreateAccountActivity;

import static com.oldspace.starcraftnet.R.id.userpassword;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void goCreateNewAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContainerView(View view){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void Login(String user, String pass){
        Toast.makeText(LoginActivity.this,pass, Toast.LENGTH_SHORT).show();

    }

}
