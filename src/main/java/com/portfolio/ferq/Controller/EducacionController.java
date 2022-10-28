
package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoEducacion;
import com.portfolio.ferq.Entity.Educacion;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    ImpEducacionService impeducacionservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impeducacionservice.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!impeducacionservice.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Educacion educacion = impeducacionservice.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!impeducacionservice.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
      } 
      impeducacionservice.delete(id);
      return new ResponseEntity(new Mensaje("Elemento eliminado"),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity (new Mensaje("El titulo es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getFechaE())){
            return new ResponseEntity (new Mensaje("La fecha es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getDescripcionE())){
            return new ResponseEntity (new Mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(impeducacionservice.existByTituloE(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoeducacion.getTituloE(),dtoeducacion.getFechaE(),dtoeducacion.getDescripcionE());
        impeducacionservice.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id")int id,@RequestBody dtoEducacion dtoeducacion){
        if(!impeducacionservice.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
        if(impeducacionservice.existByTituloE(dtoeducacion.getTituloE())&& impeducacionservice.getByTituloE(dtoeducacion.getTituloE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getFechaE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getDescripcionE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = impeducacionservice.getOne(id).get();
        educacion.setTituloE(dtoeducacion.getTituloE());
        educacion.setFechaE(dtoeducacion.getFechaE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"),HttpStatus.OK);
    }
    
    
}
