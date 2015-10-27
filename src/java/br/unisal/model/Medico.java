/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@XmlType(propOrder={"idMedico", "nome", "email"})
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;
    @Column(length = 155, name="nome_medico")
    private String nome;
    @Column(name="cpf_medico")
    private Double cpf;
    @Column(name="rg_medico")
    private Double rg;
    @Column(length = 155, name="email_medico")
    private String email;
    @Column(name ="cmr_medico")
    private Double crm;
    @Column(length = 255, name="especialidade_medico")
    private String especialidade;
    @Column(length = 255, name="telefone_medico")
    private String telefone;
    @Column(length = 255, name="endereco_medico")
    private String endereco;

    public Medico() {
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }

    public Double getRg() {
        return rg;
    }

    public void setRg(Double rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCrm() {
        return crm;
    }

    public void setCrm(Double crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idMedico);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.idMedico, other.idMedico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", nome=" + nome + 
                ", cpf=" + cpf + ", rg=" + rg + ", email=" + email + 
                ", crm=" + crm + ", especialidade=" + especialidade +'}';
    }
}
