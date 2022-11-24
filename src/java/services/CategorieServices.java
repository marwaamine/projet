/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Categorie;
import entities.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author faouzia
 */
public class CategorieServices {

    public boolean AddCategorie(Categorie c) {
        org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(c);
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

   
    public List<Categorie> listCategories() {
      List<Categorie> categories = new ArrayList<>();
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories  =  session.createQuery("from Categorie").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return categories;
    }
    
    public Categorie getCategorie(int idCat) {
        Categorie categorie = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie  = (Categorie) session.get(Categorie.class, idCat);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return categorie;
    }

    
    public boolean deleteCategorie(Categorie categorie){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(categorie);
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

    
    public boolean updateCategorie(Categorie c) {
         org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(c);
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

    public Categorie findCategorieById(int id)  {
       Categorie categorie = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie  = (Categorie) session.get(Categorie.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return categorie;
    }
}
