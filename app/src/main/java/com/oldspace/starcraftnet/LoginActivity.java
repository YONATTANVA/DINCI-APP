package com.oldspace.starcraftnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
=======
>>>>>>> parent of cac47de... login

import com.oldspace.starcraftnet.view.ContainerActivity;
import com.oldspace.starcraftnet.view.CreateAccountActivity;

import static com.oldspace.starcraftnet.R.id.userpassword;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
        user=(TextInputEditText) findViewById(R.id.usernameLogin);
        pass=(TextInputEditText) findViewById(R.id.userpassword);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Login(user.getText().toString(),pass.getText().toString());

            }
        }
        );


=======
>>>>>>> parent of cac47de... login
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
