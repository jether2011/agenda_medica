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
import br.unisal.dao.ConsultaDao;
import br.unisal.model.Consulta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "consultaBean")
@ViewScoped
public class ConsultaBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List consultas = new ArrayList();
    private Consulta consulta;    
    private ConsultaDao dao;

    //construtor
    public ConsultaBean() {        
        consultas = getDao().getAll();
        consulta = new Consulta();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(consulta);
        consultas = getDao().getAll();
        consulta = new Consulta();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(consulta);
        consultas = getDao().getAll();
        consulta = new Consulta();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(consulta);
        consultas = getDao().getAll();
        consulta = new Consulta();
    }
    
    //BackToMenu
    public String backMenu() {      
            return "/restrito/menu?faces-redirect=true";
    }

    //getters and setters
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List getConsultas() {
        return consultas;
    }

    public void setConsultas(List consultas) {
        this.consultas = consultas;
    }

    public final ConsultaDao getDao() {        
        if(dao == null){
            dao = new ConsultaDao();
        }
        return dao;
    }
}
