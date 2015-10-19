/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author pensadorx
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"idConsulta", "data", "hora", "idMedico", "idPaciente", "obs", "status"})
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Column(name="data_consulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name="hora_consulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Column(name="idMedicoConsulta")
    private Integer idMedicoConsulta;
    @Column(name="idPacienteConsulta")
    private Integer idPacienteConsulta;
    @Column(name="obs", columnDefinition = "text")
    private String obs;
    @Column(name="status")
    private Integer status;
    
    @ManyToOne
    Medico medico;
    @ManyToOne
    Paciente paciente;

    public Consulta() {
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idConsulta);
        return hash;
    }
    
    //Método toString para serializar apenas o atributo separadamente
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.idConsulta, other.idConsulta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", nome=" + nome + 
                ", email=" + email + '}';
    }
    
    
}
