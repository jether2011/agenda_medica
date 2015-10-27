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
import br.unisal.dao.PacienteDao;
import br.unisal.model.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "pacienteBean")
@ViewScoped
public class PacienteBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List pacientes = new ArrayList();
    private Paciente paciente;    
    private PacienteDao dao;

    //construtor
    public PacienteBean() {        
        pacientes = getDao().getAll();
        paciente = new Paciente();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(paciente);
        pacientes = getDao().getAll();
        paciente = new Paciente();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(paciente);
        pacientes = getDao().getAll();
        paciente = new Paciente();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(paciente);
        pacientes = getDao().getAll();
        paciente = new Paciente();
    }
    
    //BackToMenu
    public String backMenu() {      
            return "/restrito/menu?faces-redirect=true";
    }

    //getters and setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List getPacientes() {
        return pacientes;
    }

    public void setPacientes(List pacientes) {
        this.pacientes = pacientes;
    }

    public final PacienteDao getDao() {        
        if(dao == null){
            dao = new PacienteDao();
        }
        return dao;
    }
}
