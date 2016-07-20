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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndréLuiz
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id = :id"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Disciplina.findByCredito", query = "SELECT d FROM Disciplina d WHERE d.credito = :credito"),
    @NamedQuery(name = "Disciplina.findBySemestre", query = "SELECT d FROM Disciplina d WHERE d.semestre = :semestre"),
    @NamedQuery(name = "Disciplina.findByTipo", query = "SELECT d FROM Disciplina d WHERE d.tipo = :tipo")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
    @Column(name = "credito")
    private Integer credito;
    @Column(name = "semestre")
    private Integer semestre;
    @Column(name = "tipo")
    private String tipo;
    @JoinTable(name = "disciplina_grupo", joinColumns = {
        @JoinColumn(name = "_disciplina", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "_grupo", referencedColumnName = "id")})
    @ManyToMany
    private List<Grupo> grupoList;
    @JoinTable(name = "matricula_disciplina", joinColumns = {
        @JoinColumn(name = "_disciplina", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "_matricula", referencedColumnName = "id")})
    @ManyToMany
    private List<Matricula> matriculaList;

    public Disciplina() {
    }

    public Disciplina(Integer id) {
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.projeto3.Disciplina[ id=" + id + " ]";
    }
    
}
