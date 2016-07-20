/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.projeto3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndréLuiz
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinTable(name = "problema_grupo", joinColumns = {
        @JoinColumn(name = "_grupo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "_problema", referencedColumnName = "id")})
    @ManyToMany
    private List<Problema> problemaList = new ArrayList<>();;
    @ManyToMany(mappedBy = "grupoList")
    private List<Consequencia> consequenciaList = new ArrayList<>();;
    @ManyToMany(mappedBy = "grupoList")
    private List<Disciplina> disciplinaList = new ArrayList<>();
    @OneToMany(mappedBy = "grupo")
    private List<Solucao> solucaoList = new ArrayList<>();;

    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Problema> getProblemaList() {
        return problemaList;
    }

    public void setProblemaList(List<Problema> problemaList) {
        this.problemaList = problemaList;
    }

    @XmlTransient
    public List<Consequencia> getConsequenciaList() {
        return consequenciaList;
    }

    public void setConsequenciaList(List<Consequencia> consequenciaList) {
        this.consequenciaList = consequenciaList;
    }

    @XmlTransient
    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    @XmlTransient
    public List<Solucao> getSolucaoList() {
        return solucaoList;
    }

    public void setSolucaoList(List<Solucao> solucaoList) {
        this.solucaoList = solucaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.projeto3.Grupo[ id=" + id + " ]";
    }
    
}
