/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Medico;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jether
 */
public class MedicoDao{

    public void insert(Medico s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception MedicoDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(Medico s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception MedicoDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Medico> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Medico> medicos = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Medico");
            medicos = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception MedicoDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return medicos;
    }
    
    public Medico getById(Medico s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Medico medico = new Medico();
        try {
            tx.begin();
            Query query = session
                    .createQuery("FROM Medico WHERE idMedico = :id");
            query.setParameter("id", s.getIdMedico());
            medico = (Medico) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception MedicoDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return medico;
    }

    public void remove(Medico s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception MedicoDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
