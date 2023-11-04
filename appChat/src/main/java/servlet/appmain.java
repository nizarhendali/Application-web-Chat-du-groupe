package servlet;

import Entity.Message;
import Entity.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class appmain {
    public void addutilisateur(Utilisateur u){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
    }

    public void addmessage(Message msg){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        session.beginTransaction();
        session.save(msg);
        session.getTransaction().commit();

    }
    public static void main(String[] args) {
        appmain dao = new appmain();
         /* dao.addutilisateur(new Utilisateur("nizar","hendali"));
        dao.addutilisateur(new Utilisateur("nizar12","hendali12"));*/
    }
}
