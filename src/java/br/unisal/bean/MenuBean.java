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
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean implements Serializable{
    private static final long serialVersionUID = 1L;    

    //construtor
    public MenuBean() {        
    }
    //Métodos dos botões 
    public String cadastroPessoa() {      
            return "/restrito/inicio?faces-redirect=true";
    }

    public String cadastroUsuario() {      
            return "/restrito/usuario?faces-redirect=true";
    }
}
