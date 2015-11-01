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
@XmlType(propOrder={"idConsulta", "dataConsulta", "horaConsulta", "idMedicoConsulta", "idPacienteConsulta", "obs", "statusConsulta", "idMedico", "idPaciente"})
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;
//    @Column(name="data_consulta")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dataConsulta;
//    @Column(name="hora_consulta")
//    @Temporal(TemporalType.TIMESTAMP) Jether Não conseguimos converter ... 
//    private Date horaConsulta;
    @Column(name="data_consulta")
    private String dataConsulta;
    @Column(name="hora_consulta")
    private String horaConsulta;
    @Column(name="idMedicoConsulta")
    private Integer idMedicoConsulta;
    @Column(name="idPacienteConsulta")
    private Integer idPacienteConsulta;
    @Column(name="obs", columnDefinition = "text")
    private String obs;
    @Column(name="statusConsulta")
    private Integer statusConsulta;
    
    @ManyToOne
    Medico idMedico;
    @ManyToOne
    Paciente idPaciente;

    public Consulta() {
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Integer getIdMedicoConsulta() {
        return idMedicoConsulta;
    }

    public void setIdMedicoConsulta(Integer idMedicoConsulta) {
        this.idMedicoConsulta = idMedicoConsulta;
    }

    public Integer getIdPacienteConsulta() {
        return idPacienteConsulta;
    }

    public void setIdPacienteConsulta(Integer idPacienteConsulta) {
        this.idPacienteConsulta = idPacienteConsulta;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(Integer statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
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
        return "Consulta{" + "idConsulta=" + idConsulta + ", dataConsulta=" + dataConsulta + 
                ", horaConsulta=" + horaConsulta + ", idMedicoConsulta=" + idMedicoConsulta + 
                ", idPacienteConsulta=" + idPacienteConsulta + ", obs=" + obs + 
                ", statusConsulta=" + statusConsulta +'}';
    }
}
