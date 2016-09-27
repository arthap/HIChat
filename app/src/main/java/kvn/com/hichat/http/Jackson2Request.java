package kvn.com.hichat.http;

/**
 * Created by sevo on 28.09.2016.
 */
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gsmiro on 30/05/2014.
 */
public class Jackson2Request<T> extends JsonRequest<T> {

    private Class<T> clazz;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static String request(Object body) throws ParseError {
        try {
            return OBJECT_MAPPER.writeValueAsString(body);
        } catch (IOException e) {
            throw new ParseError(e);
        }
    }

    public Jackson2Request(Class<T> responseType, int method, String url, Object requestBody, Response.Listener<T> listener, Response.ErrorListener errorListener) throws ParseError {
        super(method, url, request(requestBody), listener, errorListener);
        this.clazz = responseType;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            return (Response<T>) OBJECT_MAPPER.readValue(response.data,clazz);


        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }
}