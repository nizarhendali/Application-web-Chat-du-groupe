package servlet;

import Dao.MessageDaoImpl;
import Dao.UserDaoImpl;
import Entity.Message;
import Entity.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.query.Query;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletChat", value = "/ServletChat")
public class ServletChat extends HttpServlet {

    List<String> messagesenv=new ArrayList<>();
    List<String> messagesrec=new ArrayList<>();
    List<String> listid= new ArrayList<>();
    MessageDaoImpl messageDao=new MessageDaoImpl();
    UserDaoImpl userDao=new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String text= request.getParameter("text");


     appmain app=new appmain();

        HttpSession httpSession=request.getSession();



        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        session.beginTransaction();






        Utilisateur utilisateur = userDao.getUser(httpSession.getId());
        System.out.println(utilisateur.toString());
        LocalDateTime localDateTime=LocalDateTime.now();
        messageDao.addMsg(text,utilisateur,localDateTime);






            getServletContext().getRequestDispatcher("/Chatmainpage.jsp").forward(request, response);


        }




    }

