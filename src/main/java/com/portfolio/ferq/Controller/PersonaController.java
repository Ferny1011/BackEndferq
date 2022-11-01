package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoPersona;
import com.portfolio.ferq.Entity.Persona;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontendferq.web.app","http://localhost:4200"})
public class PersonaController {
    @Autowired
    ImpPersonaService impersonaservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = impersonaservice.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!impersonaservice.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Persona persona = impersonaservice.getOne(id).get();
        return new ResponseEntity(persona,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!impersonaservice.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
      } 
      impersonaservice.delete(id);
      return new ResponseEntity(new Mensaje("Elemento eliminado"),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getApellido())){
            return new ResponseEntity (new Mensaje("El apellido es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getImg())){
            return new ResponseEntity (new Mensaje("La Url es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getCv())){
            return new ResponseEntity (new Mensaje("La Url es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getDescripcion())){
            return new ResponseEntity (new Mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(impersonaservice.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"),HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(),dtopersona.getApellido(),dtopersona.getImg(),dtopersona.getCv(),dtopersona.getDescripcion());
        impersonaservice.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id")int id,@RequestBody dtoPersona dtopersona){
        if(!impersonaservice.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
        if(impersonaservice.existsByNombre(dtopersona.getNombre())&& impersonaservice.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo nombre no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getApellido())){
            return new ResponseEntity(new Mensaje("El campo apellido no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getImg())){
            return new ResponseEntity(new Mensaje("El campo Imagen no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getCv())){
            return new ResponseEntity(new Mensaje("El campo Curriculum Vitae no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getDescripcion())){
            return new ResponseEntity(new Mensaje("El campo Descripcion no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = impersonaservice.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setImg(dtopersona.getImg());
        persona.setCv(dtopersona.getCv());
        persona.setDescripcion(dtopersona.getDescripcion());
        
        impersonaservice.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"),HttpStatus.OK);
    }
}
