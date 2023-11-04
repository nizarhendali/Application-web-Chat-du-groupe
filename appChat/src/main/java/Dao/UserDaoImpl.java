package Dao;

import Entity.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoImpl implements UserDao{
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session= sessionFactory.openSession();



    @Override
    public Utilisateur getUser(String id){

        session.beginTransaction();

        Criteria crit=session.createCriteria(Utilisateur.class);
        crit.add(Expression.eq("IdUtil", id));
        Object o=crit.uniqueResult();



        Utilisateur utilisateur =(Utilisateur) o;
        session.getTransaction().commit();
        return utilisateur;
    }



    @Override
    public List<Utilisateur> getAllusers(){


        session.beginTransaction();
        Query<Utilisateur> query = session.createQuery("FROM Utilisateur ", Utilisateur.class);
        List<Utilisateur> utilisateurs = query.getResultList();
        session.getTransaction().commit();
        return  utilisateurs;
    }

/* @Override
    public void deleteUserById(String userId) {
             session.beginTransaction();

            Utilisateur user = session.get(Utilisateur.class, userId); // Récupère l'utilisateur à supprimer en utilisant son ID
            if (user != null) {
                session.delete(user); // Supprime l'utilisateur de la base de données
                session.getTransaction().commit();
            }

    }*/





}
