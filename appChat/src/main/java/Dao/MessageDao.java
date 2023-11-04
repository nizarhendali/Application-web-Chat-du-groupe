package Dao;

import Entity.Message;
import Entity.Utilisateur;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageDao {
    List<Message> getAllmsgs();

    void addMsg(String text, Utilisateur utilisateur, LocalDateTime localDateTime);
}
