/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Consulta;
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
public class ConsultaDao{

    public void insert(Consulta s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ConsultaDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(Consulta s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ConsultaDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Consulta> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Consulta> consultas = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Consulta");
            consultas = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ConsultaDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return consultas;
    }
    
    public Consulta getById(Consulta s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Consulta consulta = new Consulta();
        try {
            tx.begin();
            Query query = session
                    .createQuery("FROM Consulta WHERE idConsulta = :id");
            query.setParameter("id", s.getIdConsulta());
            consulta = (Consulta) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ConsultaDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return consulta;
    }

    public void remove(Consulta s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ConsultaDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
