/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import entities.Client;
import entities.Produit;

import entities.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author faouzia
 */
public class UserServices {
   
      public boolean CreateUser(User user) {
         org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(user);
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
          public boolean deleteUser(User user){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(user);
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
    public User getByEmail(String email) {
        org.hibernate.Session session = null;
        Transaction transaction = null;
        User u = null;
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
             u = (Client) session.createQuery("from User where email = ?").setParameter(0, email).uniqueResult();
           transaction.commit();
        return u;
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
          return null;
    }
  
    public boolean update(User user) {
         org.hibernate.Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(user);
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
    public List<Client> findAllClients() {
         List<Client> clients = null;
         Session session = null;
         Transaction tx = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             tx = session.beginTransaction();
             clients  =  session.createQuery("from Client").list();
             tx.commit();
         } catch (HibernateException e) {
             if(tx != null)
                 tx.rollback();
         } finally {
             session.close();
         }
         return clients;
     }
    public Client findClientById(int id)  {
       Client client = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client  = (Client) session.get(Client.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return client;
    }
    
    
    
    
}
