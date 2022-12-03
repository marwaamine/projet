/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import static com.mchange.net.SmtpUtils.sendMail;
import entities.Client;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.SendMail;
import services.UserServices;
import util.Util;

/**
 *
 * @author faouzia
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private UserServices userServices;
    
    public void init (){
    userServices = new UserServices ();
}
 protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User u  = userServices.getByEmail(email);
        //int id = userServices.LoginUser(email,password);
         if(u != null){
             if(u.getPassword().equals(Util.md5(password))){
                 HttpSession session = request.getSession();
                 int id_client=u.getId();
          
                 session.setAttribute("user",u);
               
                // userServices.update(u);
                 if(u.getEtat()==0){
                       
                      response.sendRedirect("../index.jsp"); 
                 }
                 if(u.getEtat()==1){
                     response.sendRedirect("../dashboard.jsp"); 
                 }
                         
             }
                
             else {
                response.sendRedirect("login.jsp?msg=mot de passe incorrect");
            }
        } else {
            response.sendRedirect("inscription.jsp?msg=Email introuvable");
        }
        
 }
       
       //RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        // dispatcher.forward(request, response);
  
  protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String adresse = request.getParameter("adresse");
        String password = Util.md5(request.getParameter("password"));
        userServices.CreateUser(new Client(nom, prenom, telephone, adresse, email, password,0,null));
        //a modifier login sucess avec register success
         RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
         dispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {         
          HttpSession session = request.getSession(true);
        try {
            String url[] = request.getPathInfo().split("/");
            String action = url[1];
            switch(action){
                case "login" : login(request,response);
                break;
                case "register" : register(request,response);
                break;
                case "welcome" : response.getWriter().append(""+session.getAttribute("user"));
                break;
                case"mdob" : mdob(request,response);
                break;
                case "verifierCode" : verifierCode(request,response);
                break;
                case "logout" : logout(request,response);
                break;   
                case "listUsers":listUsers(request, response);
                break;
                case "deleteClient":deleteClient(request, response);
                break;    
                default : login(request,response);
                break;  
            }
          
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void mdob(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        
       User user = userServices.getByEmail(email);
        if (user != null) {
          
            double i = Math.random() * 100000;
            String code = (i + "").substring(0, 4);
            user.setCode(code);
            userServices.update(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            SendMail sed = new SendMail();
           
            //response.getWriter().append(""+email).toString();
            if( sed.send(code,email))
            response.sendRedirect("../codeverification.jsp");
            else {
                response.getWriter().append("ma kynash cnx");
            }
        } 
}
    private void verifierCode(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int code = Integer.parseInt(request.getParameter("code"));
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (Integer.parseInt(user.getCode())==code) {
                response.sendRedirect("updatemotdepasse.jsp");
            } else {
                response.sendRedirect("../codeverification.jsp?msg= le code est incorrect!! ");
            }
        } else {
            response.sendRedirect("../codeverification.jsp?msg= sesion vide!! ");
        }

    }
     private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("../index.jsp");
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
         response.getWriter().write(gson.toJson(userServices.findAllClients()));
    } 
    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            userServices.deleteUser(userServices.findClientById(id));
        } catch (NumberFormatException e) {
        }
        listUsers(request, response);
    }
}
