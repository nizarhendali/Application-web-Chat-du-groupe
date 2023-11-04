package Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    String message;
    LocalDateTime localDateTime;
    @ManyToOne
    private Utilisateur util;

    public Message(){

    }
    public Message(String msg,Utilisateur u,LocalDateTime localDateTime){
        this.message=msg;
        this.util=u;
        this.localDateTime=localDateTime;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utilisateur getUtil() {
        return util;
    }

    public void setUtil(Utilisateur util) {
        this.util = util;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id=" + Id +
                ", message='" + message + '\'' +
                ", util=" + util +
                '}';
    }
}
