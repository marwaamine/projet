/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entities.Categorie;

/**
 *
 * @author hp
 */
public class CategorieDTO {
    private final int id;
    private final String nom;

    public CategorieDTO(Categorie categorie) {
        this.id = categorie.getId();
        this.nom = categorie.getNom();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
}
