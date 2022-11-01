package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProjectos {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String categoria;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String img;
    
    @NotBlank
    private String url;
    
    public dtoProjectos() {
    }

    public dtoProjectos(String nombre, String categoria, String fecha, String img, String url) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
        this.img = img;
        this.url=url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
