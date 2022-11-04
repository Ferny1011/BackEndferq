package com.portfolio.ferq.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class HardSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private int porcentaje;
    @NotNull
    private String URLimg;

    public HardSkills() {
    }

    public HardSkills(String nombre, int porcentaje, String URLimg) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.URLimg = URLimg;
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getURLimg() {
        return URLimg;
    }

    public void setURLimg(String URLimg) {
        this.URLimg = URLimg;
    }
    
    
    
    
}
