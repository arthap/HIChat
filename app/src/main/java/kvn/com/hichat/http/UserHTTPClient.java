package kvn.com.hichat.http;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
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
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import kvn.com.hichat.ApplicationController;
import kvn.com.hichat.MainActivity;
import kvn.com.hichat.entity.User;

/**
 * Created by sevo on 21.09.2016.
 */

public class UserHTTPClient {
    private static User user = null;

    public static User getUser(){
        final String URL = "http://192.168.6.59:8080/user/registration";

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

    public static void registerUser(final User user){
        final String URL = "http://192.168.6.59:8080/user/registration";

        Map<String,String> params = new HashMap<String, String>();
        params.put("firstName",user.getFirstName());
        params.put("password",user.getPassword());
        params.put("email", user.getEmail());
        final String stringEmp = user.toString();
        StringRequest sr = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("ok");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("no");
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("firstName",user.getFirstName());
                params.put("password",user.getPassword());
                params.put("email", user.getEmail());

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };

        ApplicationController.getInstance().addToRequestQueue(sr);

    }




}
