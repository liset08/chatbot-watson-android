package com.example.vmac.WatBot.Model;

/**
 * Created by LISET on 22/05/2018.
 */

public class Pfr {


    @Override
    public String toString() {
        return "Pfr{" +
                "img_carrera='" + img_carrera + '\'' +
                ", img_malla='" + img_malla + '\'' +
                ", Objetivo='" + Objetivo + '\'' +
                ", Objetivo1='" + Objetivo1 + '\'' +
                ", Sede='" + Sede + '\'' +
                ", Duracion=" + Duracion +
                ", Descripcion='" + Descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }

    private String img_carrera;
    private String img_malla;
    private String Objetivo;
    private String Objetivo1;
    private String Sede;
    private int Duracion;
    private String Descripcion;
    private String nombre;
    private int id;

    public String getObjetivo1() {
        return Objetivo1;
    }

    public void setObjetivo1(String objetivo1) {
        Objetivo1 = objetivo1;
    }

    public String getImg_carrera() {
        return img_carrera;
    }

    public void setImg_carrera(String img_carrera) {
        this.img_carrera = img_carrera;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String Objetivo) {
        this.Objetivo = Objetivo;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_malla() {
        return img_malla;
    }

    public void setImg_malla(String img_malla) {
        this.img_malla = img_malla;
    }
}
