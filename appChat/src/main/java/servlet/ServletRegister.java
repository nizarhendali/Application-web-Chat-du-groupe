package servlet;

import Entity.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "servlet.ServletRegister", value = "/servlet.ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String name=request.getParameter("name1");
     String pass=request.getParameter("pass1");

     HttpSession httpSession = request.getSession();


     appmain app=new appmain();
        Utilisateur u =new Utilisateur(httpSession.getId(),name,pass,"actif");
        System.out.println(httpSession.getId());
     app.addutilisateur(u);



     getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);


    }
}
