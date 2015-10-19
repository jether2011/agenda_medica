/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Paciente;
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
public class PacienteDao{

    public void insert(Paciente s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PacienteDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(Paciente s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PacienteDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Paciente> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Paciente> pacientes = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Paciente");
            pacientes = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PacienteDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return pacientes;
    }
    
    public Paciente getById(Paciente s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Paciente paciente = new Paciente();
        try {
            tx.begin();
            Query query = session
                    .createQuery("FROM Paciente WHERE idPaciente = :id");
            query.setParameter("id", s.getIdPaciente());
            paciente = (Paciente) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PacienteDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return paciente;
    }

    public void remove(Paciente s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception PacienteDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
