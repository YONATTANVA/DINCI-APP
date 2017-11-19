package com.oldspace.starcraftnet.view;

import android.support.annotation.IdRes;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.oldspace.starcraftnet.Model.Citizen;
import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.view.fragment.HomeFragment;
import com.oldspace.starcraftnet.view.fragment.ProfileFragment;
import com.oldspace.starcraftnet.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.json.JSONException;
import org.json.JSONObject;

public class ContainerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        //cambiando entre los fragments del bottonbar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.tabHome);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tabProfile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,profileFragment).commit();
                        break;
                    case R.id.tabHome:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,homeFragment).commit();
                        break;
                    case R.id.tabSearch:
                        SearchFragment searchFragment  = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,searchFragment).commit();
                        break;
                }
            }
        });

        //TextView mTextView = (TextView) findViewById(R.id.text);
        //Toast toast = new Toast(getApplicationContext());


// Instantiate the RequestQueue.
        //Toast.makeText(getApplicationContext(),"asdasfasgadsgfa",Toast.LENGTH_LONG).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://localhost:3055/api/Citizen/GetAllCitizenDetails/4";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //mTxtDisplay.setText("Response: " + response.toString());
                        try {
                            Toast.makeText(getApplicationContext(),response.getString("nameCitizen"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
                    }
                });

// Access the RequestQueue through your singleton class.
        //requestQueue(jsObjRequest);
        queue.add(jsObjRequest);

    }

}
