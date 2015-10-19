/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.bean;

/**
 *
 * @author JETHER
 */
import br.unisal.dao.UsuarioDao;
import br.unisal.model.Usuario;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List usuarios = new ArrayList();
    private Usuario usuario;    
    private UsuarioDao dao;

    //construtor
    public UsuarioBean() {        
        usuarios = getDao().getAll();
        usuario = new Usuario();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        getDao().insert(usuario);
        usuarios = getDao().getAll();
        usuario = new Usuario();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(usuario);
        usuarios = getDao().getAll();
        usuario = new Usuario();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(usuario);
        usuarios = getDao().getAll();
        usuario = new Usuario();
    }
    
    //BackToMenu
    public String backMenu() {      
            return "/restrito/menu?faces-redirect=true";
    }

    //getters and setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    public final UsuarioDao getDao() {        
        if(dao == null){
            dao = new UsuarioDao();
        }
        return dao;
    }
}
