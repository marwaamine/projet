/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Lachgar
 */
@NamedQueries ( {
       @NamedQuery(name = "findByLigneCommandePK", query = "select l from LigneCommande l where l.commandePK = :lck"),
        @NamedQuery(name = "findLigneCommandeByCommande", query = "select l.commandePK , l.prixVente , l.quantité , l.produit.nom , l.produit.image from LigneCommande l where l.commandePK.commandeId = :c") 
})

@Entity
public class LigneCommande implements Serializable {
    @EmbeddedId
    private LigneCommandePK commandePK;
    private double prixVente;
    private int quantité;
    @ManyToOne
    @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commandeId", insertable = false, updatable = false)
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(LigneCommandePK commandePK, double prixVente, int quantité) {
        this.commandePK = commandePK;
        this.prixVente = prixVente;
        this.quantité = quantité;
    }



    public LigneCommande(LigneCommandePK commandePK, double prixVente, int quantité, Produit produit, Commande commande) {
        this.commandePK = commandePK;
        this.prixVente = prixVente;
        this.quantité = quantité;
        this.produit = produit;
        this.commande = commande;
    }
    
    
    
    public LigneCommandePK getCommandePK() {
        return commandePK;
    }

    public void setCommandePK(LigneCommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "commandePK=" + commandePK + ", prixVente=" + prixVente + ", quantit\u00e9=" + quantité + ", produit=" + produit + ", commande=" + commande + '}';
    }
    
   
    
}