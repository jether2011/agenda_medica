/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Usuario;
import java.security.NoSuchAlgorithmException;
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
public class UsuarioDao{

    public void insert(Usuario s) throws NoSuchAlgorithmException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            Usuario u = new Usuario(s);
            session.save(u);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UsuarioDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(Usuario s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UsuarioDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Usuario> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Usuario");
            usuarios = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UsuarioDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return usuarios;
    }
    
    public Usuario getById(Usuario s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Usuario usuario = new Usuario();
        try {
            tx.begin();
            Query query = session
                    .createQuery("FROM Usuario WHERE idUsuario = :id");
            query.setParameter("id", s.getIdUsuario());
            usuario = (Usuario) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UsuarioDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return usuario;
    }

    public void remove(Usuario s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UsuarioDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
