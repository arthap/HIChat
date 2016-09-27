package kvn.com.hichat.entity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by art on 9/12/16.
 */
public class User {

    private int id;


    private String ssoId;


    private String password;


    private String firstName;

    private String lastName;

    private String email;

    private String state;

    private Set<UserProfile> userProfiles;

    private Set<ChatSession> chatSessions ;


    public Map<String,String> userMap(){
        Map<String,String> us = new HashMap<>();
        us.put(firstName.toString(),firstName);
        us.put(email.toString(),email);
        us.put(password.toString(),password);
        return us;
    }

   // public User convertUser(JSONObject object)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public Set<ChatSession> getChatSessions() {
        return chatSessions;
    }

    public void setChatSessions(Set<ChatSession> chatSessions) {
        this.chatSessions = chatSessions;
    }

    @Override
    public String toString() {
        return       "id=" + id +
                ", ssoId='" + "sdf" + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + "sdfs" + '\'' +
                ", email='" + email + '\'' +
                ", state='" + "sdf" + '\''
                ;

    }
}
