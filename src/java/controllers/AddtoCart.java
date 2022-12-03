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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * @author User
 */
@WebServlet(name = "AddtoCart", urlPatterns = {"/AddtoCart"})
public class AddtoCart extends HttpServlet {

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
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String eid = (String)session.getAttribute("email");
       // if (eid == null) {
            // response.setContentType("application/json");
             //Gson gson = new Gson();
             //response.getWriter().write(gson.toJson(-1));
        //}
       // else {
            CommandeServices cs = new CommandeServices();
            UserServices us = new UserServices();
            LigneCommandeServices ls = new LigneCommandeServices();
            ProduitServices ps = new ProduitServices();
            Client tmp = (Client) us.getByEmail(eid);
            Commande panier = cs.findPanier();
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

        //}
        
        
        
        
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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