package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;


public class dtoDescAcercaDe {
    @NotBlank
    private String descripcion;

    public dtoDescAcercaDe() {
    }

    public dtoDescAcercaDe(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
   
    
}
