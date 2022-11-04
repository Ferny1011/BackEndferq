package com.portfolio.ferq.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud de texto no aceptada")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud de texto no aceptada")
    private String apellido;
    
    private String img;
    
    @NotNull
    @Size(min = 1, max = 70, message = "Longitud de texto no aceptada")
    private String cv;
    
    @Size(min = 1, max = 250, message = "Longitud de texto no aceptada")
    private String descripcion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String cv, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.cv = cv;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
     
}
