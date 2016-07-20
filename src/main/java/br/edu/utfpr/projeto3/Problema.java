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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "problema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problema.findAll", query = "SELECT p FROM Problema p"),
    @NamedQuery(name = "Problema.findById", query = "SELECT p FROM Problema p WHERE p.id = :id"),
    @NamedQuery(name = "Problema.findByQtdDisciplinas", query = "SELECT p FROM Problema p WHERE p.qtdDisciplinas = :qtdDisciplinas"),
    @NamedQuery(name = "Problema.findByCreditoTotal", query = "SELECT p FROM Problema p WHERE p.creditoTotal = :creditoTotal"),
    @NamedQuery(name = "Problema.findByCargaTotal", query = "SELECT p FROM Problema p WHERE p.cargaTotal = :cargaTotal"),
    @NamedQuery(name = "Problema.findBySimilaridade", query = "SELECT p FROM Problema p WHERE p.similaridade = :similaridade")})
public class Problema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qtd_disciplinas")
    private Integer qtdDisciplinas;
    @Column(name = "credito_total")
    private Integer creditoTotal;
    @Column(name = "carga_total")
    private Integer cargaTotal;
    @Column(name = "similaridade")
    private Integer similaridade;
    @ManyToMany(mappedBy = "problemaList")
    private List<Grupo> grupoList;
    @OneToMany(mappedBy = "problema")
    private List<Caso> casoList;
    @JoinColumn(name = "_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso curso;

    public Problema() {
        
        cargaTotal = 0;
        creditoTotal = 0;
        similaridade = 0;
        qtdDisciplinas = 0;
        grupoList = new ArrayList<>();
        
        
    }

    public Problema(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdDisciplinas() {
        return qtdDisciplinas;
    }

    public void setQtdDisciplinas(Integer qtdDisciplinas) {
        this.qtdDisciplinas = qtdDisciplinas;
    }

    public Integer getCreditoTotal() {
        return creditoTotal;
    }

    public void setCreditoTotal(Integer creditoTotal) {
        this.creditoTotal = creditoTotal;
    }

    public Integer getCargaTotal() {
        return cargaTotal;
    }

    public void setCargaTotal(Integer cargaTotal) {
        this.cargaTotal = cargaTotal;
    }

    public Integer getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(Integer similaridade) {
        this.similaridade = similaridade;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<Caso> getCasoList() {
        return casoList;
    }

    public void setCasoList(List<Caso> casoList) {
        this.casoList = casoList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        if (!(object instanceof Problema)) {
            return false;
        }
        Problema other = (Problema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.projeto3.Problema[ id=" + id + " ]";
    }
    
}
