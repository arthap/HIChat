package kvn.com.hichat.http;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kvn.com.hichat.ApplicationController;
import kvn.com.hichat.app.Static;
import kvn.com.hichat.entity.User;
import kvn.com.hichat.http.callback.VolleyCallback;

import static android.provider.Telephony.Carriers.PASSWORD;
import static kvn.com.hichat.app.Static.USER_EMAIL;

/**
 * Created by sevo on 21.09.2016.
 */

public class UserHTTPClient {
    private static User user = null;
    private static String URL = "http://192.168.6.59:8080/login";
    private Context context;
    public UserHTTPClient(Context obj){
        context = obj;
    }

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

    public static User get(){
        final String URL = "http://192.168.6.59:8080/user/registration";
        JacksonRequest j =  new JacksonRequest<User>(Request.Method.GET,
                URL,
                new JacksonRequestListener<User>() {
                    @Override
                    public void onResponse(User response, int statusCode, VolleyError error) {
                        System.out.println(response);
                    }

                    @Override
                    public JavaType getReturnType() {
                        return SimpleType.construct(User.class);
                    }
                });

        ApplicationController.getInstance().addToRequestQueue(j);
        return null;
    }

    public static void registerUser(final User user) throws ParseError {
        final String URL = "http://192.168.6.59:8080/user/registration";


        Jackson2Request r = new Jackson2Request(User.class, Request.Method.POST, URL, user, new Response.Listener<User>() {
            @Override
            public void onResponse(User response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("no");
            }
        });

        ApplicationController.getInstance().addToRequestQueue(r);
    }


    public  void login(final String email, final String password, final VolleyCallback callback){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(true);
                        Toast.makeText(context,response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(USER_EMAIL,email);
                params.put(PASSWORD,password);
                return params;
            }

        };
        ApplicationController.getInstance().addToRequestQueue(stringRequest);
    }



}
