package com.portfolio.ferq.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcercaDe {
        
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String Subtitulo;
   
    @NotBlank
    private String img;

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String titulo, String Subtitulo, String img) {
        this.titulo = titulo;
        this.Subtitulo = Subtitulo;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String Subtitulo) {
        this.Subtitulo = Subtitulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
