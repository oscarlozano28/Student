/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author osmal
 */
@Embeddable
public class CoursespkPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEID")
    private int courseid;

    public CoursespkPK() {
    }

    public CoursespkPK(int studentid, int courseid) {
        this.studentid = studentid;
        this.courseid = courseid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentid;
        hash += (int) courseid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursespkPK)) {
            return false;
        }
        CoursespkPK other = (CoursespkPK) object;
        if (this.studentid != other.studentid) {
            return false;
        }
        if (this.courseid != other.courseid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.CoursespkPK[ studentid=" + studentid + ", courseid=" + courseid + " ]";
    }
    
}
