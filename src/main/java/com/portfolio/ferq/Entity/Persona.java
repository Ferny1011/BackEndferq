package com.portfolio.ferq.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud de texto no aceptada")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud de texto no aceptada")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud de texto no aceptada")
    private String img;
    
    @NotNull
    @Size(min = 1, max = 70, message = "Longitud de texto no aceptada")
    private String cv;
    
    @Size(min = 1, max = 250, message = "Longitud de texto no aceptada")
    private String descripcion;
     
}
