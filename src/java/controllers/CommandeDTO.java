/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Commande;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class CommandeDTO {
    private final Date date;
    private  int produits;
    private  double prixTotal;
    private final String client;

    public CommandeDTO(Commande commande) {
        this.date=commande.getDate();
        this.produits=0;
        this.prixTotal=0;
        commande.getLigneCommandes().forEach(x->{
            this.produits+=x.getQuantité();
            this.prixTotal+=x.getPrixVente();
        });
        this.client= commande.getClient().getNom() + " " +commande.getClient().getPrenom();
    
    }

    public Date getDate() {
        return date;
    }

    public int getProduits() {
        return produits;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public String getClient() {
        return client;
    }
    
    
    
    
    
   
}
