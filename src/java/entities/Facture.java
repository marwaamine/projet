/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author faouzia
 */
@Entity
public class Facture implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private Date date ;
    private double montant;
    @OneToMany(targetEntity=Commande.class,mappedBy = "facture", fetch = FetchType.EAGER)
    private List<Commande> commandes =new ArrayList<Commande>();
           
            
            
    public Facture() {
    }

    public Facture(int id, Date date, double montant) {
        this.id = id;
        this.date = date;
        this.montant = montant;
    }

    public Facture(Date date, double montant) {
        this.date = date;
        this.montant = montant;
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    
    
}
