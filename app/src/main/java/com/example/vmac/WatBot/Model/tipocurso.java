package com.example.vmac.WatBot.Model;

/**
 * Created by LISET on 27/05/2018.
 */

public class tipocurso {


    @Override
    public String toString() {
        return "tipocurso{" +
                "id=" + id +
                ", img_curso='" + img_curso + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Fech_inic='" + Fech_inic + '\'' +
                ", Fech_fin='" + Fech_fin + '\'' +
                ", precio='" + precio + '\'' +
                ", objetivos='" + objetivos + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    private int id;
    private String img_curso;
    private String Nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_curso() {
        return img_curso;
    }

    public void setImg_curso(String img_curso) {
        this.img_curso = img_curso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFech_inic() {
        return Fech_inic;
    }

    public void setFech_inic(String fech_inic) {
        Fech_inic = fech_inic;
    }

    public String getFech_fin() {
        return Fech_fin;
    }

    public void setFech_fin(String fech_fin) {
        Fech_fin = fech_fin;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    private String Fech_inic;
    private String Fech_fin;
    private String precio;
    private String objetivos;
    private String Descripcion;


}
