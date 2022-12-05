/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lachgar
 */
@NamedQueries({
    @NamedQuery(name = "findPanier", query = "select c from Commande c where c.status = 'en cours'"),
    })
@Entity
public class Commande implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    
    @ManyToOne
    private Client client;
    
    @ManyToOne(cascade = CascadeType.DETACH)
    private Facture facture;
    
    @OneToMany(mappedBy = "commande",fetch = FetchType.EAGER)
    private List<LigneCommande> lignecommande;
    
    private String status;
    
    public Commande() {
    }

    public Commande(Date date, Client client) {
        this.date = date;
        this.client = client;
        this.status = "en cours";
    }
    
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public List<LigneCommande> getLignecommande() {
        return lignecommande;
    }

    public void setLignecommande(List<LigneCommande> lignecommande) {
        this.lignecommande = lignecommande;
    }
    
    
}