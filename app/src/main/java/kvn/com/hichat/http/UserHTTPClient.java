package kvn.com.hichat.http;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import kvn.com.hichat.ApplicationController;
import kvn.com.hichat.entity.User;

/**
 * Created by sevo on 21.09.2016.
 */

public class UserHTTPClient {
    private static User user = null;

    public static User getUser(){
        final String URL = "http://localhost:8080/user/registration";

        final StringRequest req = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            user =  objectMapper.readValue(response.getBytes(),User.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Response is: " + user);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });
        ApplicationController.getInstance().addToRequestQueue(req);
        return  user;
    }




}
