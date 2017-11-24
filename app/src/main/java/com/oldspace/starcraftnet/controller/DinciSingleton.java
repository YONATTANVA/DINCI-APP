package com.oldspace.starcraftnet.controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by YonattanVisita on 24/11/2017.
 */

public final class DinciSingleton {

    private static DinciSingleton singleton;
    private static Context context;
    private RequestQueue requestQueue;

    private DinciSingleton(Context context){
        DinciSingleton.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized DinciSingleton getIntance(Context context){
        if(singleton == null){
            singleton = new DinciSingleton(context);
        }
        return singleton;
    }


    public RequestQueue getRequestQueue(){
        if(this.requestQueue == null){
            this.requestQueue = Volley.newRequestQueue(this.context.getApplicationContext());
        }
        return this.requestQueue;
    }

    public void addToRequestQueue(Request request){
        getRequestQueue().add(request);
    }

}
