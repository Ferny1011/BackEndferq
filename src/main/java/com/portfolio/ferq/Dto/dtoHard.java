package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHard {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    private String URLimg;
    

    public dtoHard() {
    }

    public dtoHard(String nombre, int porcentaje, String URLimg) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.URLimg = URLimg;
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
