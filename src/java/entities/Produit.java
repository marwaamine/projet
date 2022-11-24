/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author faouzia
 */
@Entity
public class Produit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String nom;
    private String description ;
    private String designation;
    private double prix;
    private String image;
    private int unite ;
    @ManyToOne
    
    private Marque marque ;
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;
   
    
    public Produit() {
    }

    public Produit(String nom, String description, String designation, double prix, String image, int unite) {
        this.nom = nom;
        this.description = description;
        this.designation = designation;
        this.prix = prix;
        this.image = image;
        this.unite = unite;
    }

    public Produit(String nom, String description, String designation, double prix, String image, int unite, Marque marque, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.designation = designation;
        this.prix = prix;
        this.image = image;
        this.unite = unite;
        this.marque = marque;
        this.categorie = categorie;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUnite() {
        return unite;
    }

    public void setUnite(int unite) {
        this.unite = unite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
}
