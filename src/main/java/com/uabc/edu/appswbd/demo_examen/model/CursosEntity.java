package com.uabc.edu.appswbd.demo_examen.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="TBL_COURSES")
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;

    @Column(name="nombre_curso")
    private String nameCurso;

    @Column(name="descripcion_curso")
    private String descripCurso;

    @Column(name="duracion_curso")
    private String duracionCurso;



    @Column(name="url_curso")
    private String urlCurso;




    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public String getDescripCurso() {
        return descripCurso;
    }

    public void setDescripCurso(String descripCurso) {
        this.descripCurso = descripCurso;
    }

    public String getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(String duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public String getUrlCurso() {
        return urlCurso;
    }

    public void setUrlCurso(String urlCurso) {
        this.urlCurso = urlCurso;
    }

    @Override
    public String toString() {
        return "CursosEntity [idC=" + idC + ", nameCurso=" + nameCurso +
                ", descripCurso=" + descripCurso + ",duracionCurso="+duracionCurso+",urlCurso="+urlCurso+"]";
    }
}
