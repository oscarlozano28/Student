/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author osmal
 */
@Entity
@Table(name = "COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course_1.findAll", query = "SELECT c FROM Course_1 c"),
    @NamedQuery(name = "Course_1.findByCourseid", query = "SELECT c FROM Course_1 c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Course_1.findByNombre", query = "SELECT c FROM Course_1 c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Course_1.findByNumcreditos", query = "SELECT c FROM Course_1 c WHERE c.numcreditos = :numcreditos"),
    @NamedQuery(name = "Course_1.findBySemestre", query = "SELECT c FROM Course_1 c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Course_1.findByAdmitidos", query = "SELECT c FROM Course_1 c WHERE c.admitidos = :admitidos")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEID")
    private Integer courseid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NUMCREDITOS")
    private Integer numcreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "ADMITIDOS")
    private Integer admitidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<Coursespk> coursespkCollection;

    public Course() {
    }

    public Course(Integer courseid, String nombre, Integer numcreditos, Integer semestre, Integer admitidos) {
        this.courseid = courseid;
        this.nombre = nombre;
        this.numcreditos = numcreditos;
        this.semestre = semestre;
        this.admitidos = admitidos;
    }

    public Course(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumcreditos() {
        return numcreditos;
    }

    public void setNumcreditos(Integer numcreditos) {
        this.numcreditos = numcreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAdmitidos() {
        return admitidos;
    }

    public void setAdmitidos(Integer admitidos) {
        this.admitidos = admitidos;
    }

    @XmlTransient
    public Collection<Coursespk> getCoursespkCollection() {
        return coursespkCollection;
    }

    public void setCoursespkCollection(Collection<Coursespk> coursespkCollection) {
        this.coursespkCollection = coursespkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.Course_1[ courseid=" + courseid + " ]";
    }
    
}
