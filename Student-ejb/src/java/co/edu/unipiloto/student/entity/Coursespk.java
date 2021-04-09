/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author osmal
 */
@Entity
@Table(name = "COURSESPK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coursespk.findAll", query = "SELECT c FROM Coursespk c"),
    @NamedQuery(name = "Coursespk.findByStudentid", query = "SELECT c FROM Coursespk c WHERE c.coursespkPK.studentid = :studentid"),
    @NamedQuery(name = "Coursespk.findByCourseid", query = "SELECT c FROM Coursespk c WHERE c.coursespkPK.courseid = :courseid"),
    @NamedQuery(name = "Coursespk.findByNota", query = "SELECT c FROM Coursespk c WHERE c.nota = :nota")})
public class Coursespk implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoursespkPK coursespkPK;
    @Column(name = "NOTA")
    private Integer nota;
    @JoinColumn(name = "COURSEID", referencedColumnName = "COURSEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Coursespk() {
    }

    public Coursespk(CoursespkPK coursespkPK) {
        this.coursespkPK = coursespkPK;
    }

    public Coursespk(int studentid, int courseid) {
        this.coursespkPK = new CoursespkPK(studentid, courseid);
    }

    public CoursespkPK getCoursespkPK() {
        return coursespkPK;
    }

    public void setCoursespkPK(CoursespkPK coursespkPK) {
        this.coursespkPK = coursespkPK;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursespkPK != null ? coursespkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coursespk)) {
            return false;
        }
        Coursespk other = (Coursespk) object;
        if ((this.coursespkPK == null && other.coursespkPK != null) || (this.coursespkPK != null && !this.coursespkPK.equals(other.coursespkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.Coursespk[ coursespkPK=" + coursespkPK + " ]";
    }
    
}
