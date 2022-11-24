/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Categorie;
import entities.Marque;
import entities.Produit;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class MarqueServices {
    public boolean AddMarque(Marque marque) {
        org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(marque);
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
    public boolean deleteMarque(Marque marque)  {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(marque);
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
    
    
    
    
    public boolean updateMarque(Marque marque) {
         org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(marque);
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
    public List<Marque> findMarques() {
        List<Marque> marques = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            marques =  session.createQuery("from Marque").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return marques;
    }
    

  
     public Marque findMarqueById(int id)  {
       Marque marque = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            marque  = (Marque) session.get(Marque.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return marque;
    }
    
}
