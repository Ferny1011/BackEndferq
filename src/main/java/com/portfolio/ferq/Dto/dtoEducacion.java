package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String fechaE;
    @NotBlank
    private String tituloE;
    @NotBlank
    private String descripcionE;

    public dtoEducacion() {
    }

    public dtoEducacion(String fechaE, String tituloE, String descripcionE) {
        this.fechaE = fechaE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
    
}
