/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Categorie;
import entities.Client;
import entities.Marque;
import entities.Produit;
import org.hibernate.Hibernate;
import services.CategorieServices;
import services.MarqueServices;
import services.ProduitServices;
import services.UserServices;
import util.HibernateUtil;

/**
 *
 * @author a
 */
public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        UserServices us = new UserServices();
        ProduitServices ps = new ProduitServices();
        MarqueServices ms = new MarqueServices();
         CategorieServices cs = new CategorieServices();
     //   ps.AddProduit(new Produit("dell", "dell core i5", "pc dell", 25000, "xx", 2));
        // ms.AddMarque(new Marque(1, "HP"));
     // ms.AddMarque(new Marque("HP"));
     // ms.AddMarque(new Marque("dell"));
     //ms.AddMarque(new Marque("ASUS"));
      
       // cs.AddCategorie(new Categorie("Ordinateurs"));
      //  ps.findproduitsParCategorie(1);
     //  ps.AddProduit(new Produit("pc hp", "hp core i5", "i5", 27000, "hp", 20,ms.findMarqueById(1) , cs.findCategorieById(1)));
     //  ps.AddProduit(new Produit("pc dell", "dell core i5", "i5", 2800, "dell", 20,ms.findMarqueById(2) , cs.findCategorieById(1)));
     //  us.LoginUser("fouzia@gmail.com", "1234");
       // us.CreateClient(new Client("f", "f", "0666", "eljadida", "f@gmail.com", "123"));
       
       //for(Marque marque:  ms.findMarques()){
         //   System.out.println("done");
    //    }
       // System.out.println("done");   
      System.out.println(ps.findAllProduits());
    
    }
}
