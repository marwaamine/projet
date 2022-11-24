/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Produit;
import java.rmi.RemoteException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author faouzia
 */
public class ProduitServices {
    public boolean AddProduit(Produit produit) {
         org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(produit);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }
    
    
    
    
    
    
      public boolean updateProduit(Produit produit)  {
        org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(produit);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }
    
  public boolean deleteProduit(Produit produit)  {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(produit);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }
   public List<Produit> findAllProduits() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits  =  session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produits;
    }
    public Produit findProduitById(int id)  {
       Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit  = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produit;
    }
    public List<Produit> findproduitsParCategorie(int idCat){
         List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try{
             session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = (List<Produit>) (Produit) session.createQuery("FROM Produit P WHERE P.categorie_id= : idCat").setParameter(idCat, idCat).list();
         tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produits;
    }
    }

