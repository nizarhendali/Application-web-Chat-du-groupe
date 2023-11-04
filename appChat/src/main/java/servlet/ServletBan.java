package servlet;

import Dao.MessageDaoImpl;
import Dao.UserDaoImpl;
import Entity.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletBan", value = "/ServletBan")
public class ServletBan extends HttpServlet {

    UserDaoImpl userDao=new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String iduser=(String) request.getAttribute("iduser");
        Utilisateur utilisateur=userDao.getUser(iduser);
        utilisateur.setType("ban");
        getServletContext().getRequestDispatcher("/Chatmainpage.jsp").forward(request,response);


    }
}
