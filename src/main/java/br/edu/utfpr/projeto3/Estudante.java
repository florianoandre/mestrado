/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.projeto3;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "estudante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudante.findAll", query = "SELECT e FROM Estudante e"),
    @NamedQuery(name = "Estudante.findById", query = "SELECT e FROM Estudante e WHERE e.id = :id"),
    @NamedQuery(name = "Estudante.findByNome", query = "SELECT e FROM Estudante e WHERE e.nome = :nome"),
    @NamedQuery(name = "Estudante.findByAnoIngresso", query = "SELECT e FROM Estudante e WHERE e.anoIngresso = :anoIngresso"),
    @NamedQuery(name = "Estudante.findBySemestreIngresso", query = "SELECT e FROM Estudante e WHERE e.semestreIngresso = :semestreIngresso"),
    @NamedQuery(name = "Estudante.findByStatus", query = "SELECT e FROM Estudante e WHERE e.status = :status")})
public class Estudante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "ano_ingresso")
    private Integer anoIngresso;
    @Column(name = "semestre_ingresso")
    private Integer semestreIngresso;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "estudante")
    private List<Matricula> matriculaList;
    @JoinColumn(name = "_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso curso;

    public Estudante() {
    }

    public Estudante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public Integer getSemestreIngresso() {
        return semestreIngresso;
    }

    public void setSemestreIngresso(Integer semestreIngresso) {
        this.semestreIngresso = semestreIngresso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
        if (!(object instanceof Estudante)) {
            return false;
        }
        Estudante other = (Estudante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.projeto3.Estudante[ id=" + id + " ]";
    }
    
}
