package kvn.com.hichat.entity;

import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;




public class GetData extends AsyncTask<Void,Void,User> {
    String host="http://localhost:8080/user/registration";
    @Override
    protected User doInBackground(Void... params) {
        RestTemplate templ=new RestTemplate();

        templ.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User us=templ.getForObject(host,User.class);
        return us;
    }



    @Override
    protected void onPostExecute(User user) {
        List<User> userList=new ArrayList<>();
        userList.add(user);
    }
}
