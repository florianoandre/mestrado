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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id"),
    @NamedQuery(name = "Matricula.findByAnoMatricula", query = "SELECT m FROM Matricula m WHERE m.anoMatricula = :anoMatricula"),
    @NamedQuery(name = "Matricula.findBySemestreMatricula", query = "SELECT m FROM Matricula m WHERE m.semestreMatricula = :semestreMatricula")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ano_matricula")
    private Integer anoMatricula;
    @Column(name = "semestre_matricula")
    private Integer semestreMatricula;
    @ManyToMany(mappedBy = "matriculaList")
    private List<Disciplina> disciplinaList;
    @JoinColumn(name = "_estudante", referencedColumnName = "id")
    @ManyToOne
    private Estudante estudante;

    public Matricula() {
    }

    public Matricula(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(Integer anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    public Integer getSemestreMatricula() {
        return semestreMatricula;
    }

    public void setSemestreMatricula(Integer semestreMatricula) {
        this.semestreMatricula = semestreMatricula;
    }

    @XmlTransient
    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
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
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.projeto3.Matricula[ id=" + id + " ]";
    }
    
}
