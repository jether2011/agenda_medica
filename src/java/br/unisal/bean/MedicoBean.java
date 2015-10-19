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
import br.unisal.dao.MedicoDao;
import br.unisal.model.Medico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "medicoBean")
@ViewScoped
public class MedicoBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List medicos = new ArrayList();
    private Medico medico;    
    private MedicoDao dao;

    //construtor
    public MedicoBean() {        
        medicos = getDao().getAll();
        medico = new Medico();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(medico);
        medicos = getDao().getAll();
        medico = new Medico();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(medico);
        medicos = getDao().getAll();
        medico = new Medico();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(medico);
        medicos = getDao().getAll();
        medico = new Medico();
    }
    
    //BackToMenu
    public String backMenu() {      
            return "/restrito/menu?faces-redirect=true";
    }

    //getters and setters
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List getMedicos() {
        return medicos;
    }

    public void setMedicos(List medicos) {
        this.medicos = medicos;
    }

    public final MedicoDao getDao() {        
        if(dao == null){
            dao = new MedicoDao();
        }
        return dao;
    }
}
