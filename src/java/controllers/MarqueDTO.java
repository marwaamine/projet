/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Marque;

/**
 *
 * @author hp
 */
public class MarqueDTO {
    private final int id;
    private final String nom;

    public MarqueDTO(Marque marque) {
        this.id = marque.getId();
        this.nom = marque.getNom();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    
    
}

