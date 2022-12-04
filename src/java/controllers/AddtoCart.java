/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Categorie;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.LigneCommandePK;
import entities.Produit;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.CommandeServices;
import services.LigneCommandeServices;
import services.ProduitServices;
import services.UserServices;


/**
 *
 * @author faouzia
 */
@WebServlet(name = "AddtoCart", urlPatterns = {"/AddtoCart"})
public class AddtoCart extends HttpServlet {
     private UserServices userServices;
    
    public void init (){
    userServices = new UserServices ();
}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String email = request.getParameter("email");
        User u  = userServices.getByEmail(email);    
        HttpSession session = request.getSession();
        User userid  = (User) session.getAttribute("user") ;
        int id_client=userid.getId();
        String email_client = userid.getEmail();
        //response.getWriter().append(""+email_client);
       // response.getWriter().append("id client est : "+userid.getId());
       // response.getWriter().append("idclient"+ id_client);

         if (email_client==null) {
                 response.getWriter().write("Veuillez se connecter d'abord");
         }
         if (id_client== 0) {

            response.setContentType("application/json");
             Gson gson = new Gson();
        }
       else {
            CommandeServices cs = new CommandeServices();
            UserServices us = new UserServices();
            LigneCommandeServices ls = new LigneCommandeServices();
            ProduitServices ps = new ProduitServices();
            Client tmp = (Client) us.getByEmail(email_client);
            Commande panier = cs.findPanier();
           // response.getWriter().append("test : "+panier);
           if(panier==null){
                panier = new Commande(new Date(),tmp);
                cs.AddCommande(panier);  
            }
            int commandeid = panier.getId();
            int idProduit = Integer.parseInt(request.getParameter("id"));
            int nb = Integer.parseInt(request.getParameter("nb"));
            
            // ID de la commande en cours (a ajouter dans la couche service)
            
            LigneCommandePK lcpk = new LigneCommandePK(idProduit, commandeid);
            LigneCommande lctmp = ls.getByPK(lcpk);
            if(lctmp==null){
                ls.create(new LigneCommande(lcpk, (ps.findProduitById(idProduit)).getPrix() ,nb ));
            }
            if(lctmp!=null) {
              //
                lctmp.setQuantité(lctmp.getQuantité()+nb);
                lctmp.setPrixVente((ps.findProduitById(idProduit)).getPrix());
                
                ls.update(lctmp);
            }
               
           RequestDispatcher rd = request.getRequestDispatcher("/panier.jsp");
           rd.forward(request,response);

       }
            }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(AddtoCart.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}