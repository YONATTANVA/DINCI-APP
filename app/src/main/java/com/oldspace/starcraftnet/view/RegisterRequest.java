package com.oldspace.starcraftnet.view;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 23/11/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final  String REGISTER_REQUEST_URL = "http://www.dinci.somee.com/api/citizen/AddCitizen";
    private Map<String,String> params;

    public RegisterRequest(String name, String pass,String dni, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nameCitizen",name);
        params.put("passwordCitizen",pass);
        params.put("phonenumberCitizen",dni);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
