package Dao;

import Entity.Message;
import Entity.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import servlet.appmain;

import java.time.LocalDateTime;
import java.util.List;

public class MessageDaoImpl implements MessageDao{
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session= sessionFactory.openSession();
    appmain app=new appmain();


    @Override
    public List<Message> getAllmsgs(){


        session.beginTransaction();
        Query<Message> query = session.createQuery("FROM Message", Message.class);
        List<Message> messages = query.getResultList();
        session.getTransaction().commit();
        return  messages;
    }

    @Override
    public void addMsg(String text, Utilisateur utilisateur, LocalDateTime localDateTime){

        Message msg=new Message(text,utilisateur,localDateTime);
        app.addmessage(msg);
    }
}
