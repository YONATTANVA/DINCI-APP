package com.oldspace.starcraftnet.view;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.view.fragment.HomeFragment;
import com.oldspace.starcraftnet.view.fragment.ProfileFragment;
import com.oldspace.starcraftnet.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        //cambiando entre los fragments del bottonbar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,profileFragment).commit();
                        break;
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,homeFragment).commit();
                        break;
                    case R.id.search:
                        SearchFragment searchFragment  = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerOfFragments,searchFragment).commit();
                        break;
                }
            }
        });

    }
    public void registerIncident(View view){


    }

}
