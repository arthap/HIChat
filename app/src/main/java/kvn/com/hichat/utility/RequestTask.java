/*
package kvn.com.hichat.utility;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import kvn.com.hichat.entity.User;

import static org.springframework.http.HttpMethod.POST;

*/
/**
 * Created by sevo on 19.09.2016.
 *//*


public class RequestTask<T> extends AsyncTask<Object, Void, T> {


    @Override
    protected T doInBackground(Object... fields) {
        RestTemplate templ = new RestTemplate();
        String url = (String) fields[0];
        HttpMethod method = HttpMethod.valueOf(String.valueOf(fields[1]));
        T obj = (T) fields[2];
        Map<String, String> params = new HashMap<>();
        templ.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        switch (method) {
            case POST:
                return postFor(templ, url, obj);
            case GET:
                if (params != null) {
                    return getFor(templ, url, params);
                } else {
                    return getFor(templ, url, null);
                }
            case PUT:
                if (params != null) {
                    putFor(templ, url, obj, params);
                } else {
                    putFor(templ, url, obj, null);
                }
                break;
            case DELETE:
                deleteFor(templ, url, params);
                break;
        }
        return null;
    }

    private T getFor(RestTemplate restTemplate, String uri, Map<String, String> params) {
        if (params != null)
            return (T) restTemplate.getForObject(uri, Object.class, params);
        return (T) restTemplate.getForObject(uri, Object.class);

    }

    private T postFor(RestTemplate restTemplate, String uri, T obj) {
        return (T) restTemplate.postForObject(uri, obj, Object.class);
    }

    private void putFor(RestTemplate restTemplate, String uri, T obj, Map<String, String> params) {
        if (params != null)
            restTemplate.put(uri, obj, params);
        restTemplate.put(uri, obj);
    }


    private void deleteFor(RestTemplate restTemplate, String uri, Map<String, String> params) {
        restTemplate.put(uri, params);
    }
}
*/
