package com.uabc.edu.appswbd.demo_examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TAKECOURSES")
public class TakeCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTC;
    @Column(name = "employee")
    private String employee;
    @Column(name = "course")
    private String course;
    @Column(name = "date")
    private String dateC;

    public Integer getIdTC() {
        return idTC;
    }

    public void setIdTC(Integer idTC) {
        this.idTC = idTC;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    @Override
    public String toString() {
        return "TakeCourseEntity [course=" + course + ", dateC=" + dateC + ", employee=" + employee + ", idTC=" + idTC
                + "]";
    }
}