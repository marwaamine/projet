/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Commande;
import entities.LigneCommande;
import entities.LigneCommandePK;
import entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ProduitServices;

/**
 *
 * @author faouzia
 */
@WebServlet("/client/*")
public class ClientController extends HttpServlet {

    List<Commande> commandes = new ArrayList<>();
    List<LigneCommande> ligneCommandes = new ArrayList<>();
    private ProduitServices produitServices = new ProduitServices();
    private Produit p;

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
        response.setContentType("text/html;charset=UTF-8");

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
        HttpSession session = request.getSession(true);
        try {
            String url[] = request.getPathInfo().split("/");
            String action = url[1];
            switch (action) {
                case "AjouterPanier":
                    AjouterPanier(request, response);
                    break;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void AjouterPanier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        int id_produit = Integer.parseInt(request.getParameter("id"));
        System.out.println(id_produit);

        p = produitServices.findProduitById(id_produit);
        System.out.println(p);
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        double prixVente = p.getPrix() * quantite;
        // response.getWriter().append("x" +id_produit);
        LigneCommande lc = new LigneCommande(prixVente, quantite, p, (Commande) session.getAttribute("cart"));
        Commande c = (Commande) session.getAttribute("cart");
        List<LigneCommande> lis = c.getLigneCommandes();
        System.out.println(c.getLigneCommandes());
        if (lis == null) {
            c.setLigneCommandes(new ArrayList<>());
        }
        c.getLigneCommandes().add(lc);
        Gson gson = new Gson();
        CommandeDTO m = new CommandeDTO(c);
        System.out.println(m);
        response.getWriter().write(gson.toJson(m));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
