package kvn.com.hichat.entity;

/**
 * Created by art on 9/7/16.
 */

public class ChatSession {

    private int chat_id;
    private String Initiator ;
    private  String Partner;
    private  int  topic_id;
    private User user;

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getInitiator() {
        return Initiator;
    }

    public void setInitiator(String initiator) {
        Initiator = initiator;
    }

    public String getPartner() {
        return Partner;
    }

    public void setPartner(String partner) {
        Partner = partner;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
