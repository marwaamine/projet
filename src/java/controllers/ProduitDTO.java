/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import entities.Marque;
import entities.Produit;

/**
 *
 * @author hp
 */
public class ProduitDTO {

    private final int id;
    private final String nom;
    private final String designation;
    private final int unite;
    private final double prix;
    private final String description;
    private final String marque;
    private final String categorie;

    public ProduitDTO(Produit produit) {
        this.id = produit.getId();
        this.nom = produit.getNom();
        this.designation = produit.getDesignation();
        this.unite = produit.getUnite();
        this.prix = produit.getPrix();
        this.description = produit.getDescription();
        Marque M = produit.getMarque();
        this.marque = M == null ? "" : M.getNom();
        Categorie C = produit.getCategorie();
        this.categorie = C == null ? "" : C.getNom();

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDesignation() {
        return designation;
    }

    public int getUnite() {
        return unite;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public String getMarque() {
        return marque;
    }

    public String getCategorie() {
        return categorie;
    }

}
