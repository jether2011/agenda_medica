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
    public String cadastroMedico() {      
            return "/restrito/cadMedico?faces-redirect=true";
    }

    public String cadastroUsuario() {      
            return "/restrito/cadUsuario?faces-redirect=true";
    }
    
    public String cadastroPaciente() {      
            return "/restrito/cadPaciente?faces-redirect=true";
    }
    
    public String cadastroConsulta() {      
            return "/restrito/cadConsulta?faces-redirect=true";
    }
}
