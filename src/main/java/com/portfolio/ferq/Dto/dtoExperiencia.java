package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String fechaE;
    @NotBlank
    private String descripcionE;
    
    //Constructors

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String fechaE, String descripcionE) {
        this.nombreE = nombreE;
        this.fechaE = fechaE;
        this.descripcionE = descripcionE;
    }
    
    //Getters & Settters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}
