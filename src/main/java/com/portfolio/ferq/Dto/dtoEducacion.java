package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String fechaE;
    @NotBlank
    private String tituloE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String imgE;
    
    private String urlE;

    public dtoEducacion() {
    }

    public dtoEducacion(String fechaE, String tituloE, String descripcionE, String imgE, String urlE) {
        this.fechaE = fechaE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
        this.urlE = urlE;
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

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }


    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }
    
    

}
