package servlet;

import Entity.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "servlet.Servletlogin", value = "/servlet.Servletlogin")
public class Servletlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name= request.getParameter("name");
        String pass=request.getParameter("pass");

       System.out.println(name +" "+pass);




        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
     Query query = session.createQuery("SELECT nom FROM Utilisateur ");

        List lists= query.getResultList();

        boolean userFound = false;


        for (Object i : lists) {
            String r = (String) i;
            if (r.equals(name)) {
                Query query1 = session.createQuery("SELECT password FROM Utilisateur WHERE nom=:r");
                query1.setParameter("r", r);
                String passw = (String) ((org.hibernate.query.Query<?>) query1).uniqueResult();

                if (passw != null && passw.equals(pass)) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Chatmainpage.jsp");
                    rd.forward(request, response);
                    return;
                } else {
                    System.out.println(passw);
                    System.out.println(pass);
                    break;
                }
            }
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ban.jsp");
        rd.forward(request, response);



    }
}












