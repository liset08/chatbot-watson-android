package com.example.vmac.WatBot.Model;

/**
 * Created by LISET on 30/05/2018.
 */

public class Cpe {

    @Override
    public String toString() {
        return "Cpe{" +
                "Tipo='" + Tipo + '\'' +
                ", Area='" + Area + '\'' +
                ", Duracion=" + Duracion +
                ", Temario='" + Temario + '\'' +
                ", Objetivo='" + Objetivo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Sede='" + Sede + '\'' +
                ", fec_inic='" + fec_inic + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", id=" + id +
                ", Precio='" + Precio + '\'' +
                '}';
    }

    private String Tipo;
    private String Area;
    private String Duracion;
    private String Temario;

    private String Objetivo;
    private String Descripcion;
    private String Sede;
    private String fec_inic;
    private String Nombre;
    private int id;


    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    private String Precio;




    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getTemario() {
        return Temario;
    }

    public void setTemario(String Temario) {
        this.Temario = Temario;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String Objetivo) {
        this.Objetivo = Objetivo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getFec_inic() {
        return fec_inic;
    }

    public void setFec_inic(String fec_inic) {
        this.fec_inic = fec_inic;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
