package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoProjectos;
import com.portfolio.ferq.Entity.Projectos;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpProjectosService;
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
@RequestMapping("/projectos")
@CrossOrigin(origins = {"https://frontendferq.web.app", "http://localhost:4200"})
public class ProjectosController {

    @Autowired
    ImpProjectosService imProjectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Projectos>> list() {
        List<Projectos> list = imProjectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Projectos> getById(@PathVariable("id") int id) {
        if (!imProjectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        Projectos projectos = imProjectosService.getOne(id).get();
        return new ResponseEntity(projectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!imProjectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        imProjectosService.delete(id);
        return new ResponseEntity(new Mensaje("Projecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjectos dtoprojectos) {
        if (StringUtils.isBlank(dtoprojectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getImg())) {
            return new ResponseEntity(new Mensaje("La Imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getFecha())) {
            return new ResponseEntity(new Mensaje("La Fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getUrl())) {
            return new ResponseEntity(new Mensaje("La Url es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (imProjectosService.existsByNombre(dtoprojectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese projecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Projectos projectos = new Projectos(dtoprojectos.getNombre(), dtoprojectos.getCategoria(), dtoprojectos.getFecha(), dtoprojectos.getImg(),dtoprojectos.getUrl());
        imProjectosService.save(projectos);
        return new ResponseEntity(new Mensaje("Projecto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjectos dtoprojectos) {
        if (!imProjectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (imProjectosService.existsByNombre(dtoprojectos.getNombre()) && imProjectosService.getByNombre(dtoprojectos.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getImg())) {
            return new ResponseEntity(new Mensaje("El campo Imagen no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getFecha())) {
            return new ResponseEntity(new Mensaje("El campo Fecha no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoprojectos.getUrl())) {
            return new ResponseEntity(new Mensaje("El campo Url no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Projectos projectos = imProjectosService.getOne(id).get();
        projectos.setNombre(dtoprojectos.getNombre());
        projectos.setCategoria(dtoprojectos.getCategoria());
        projectos.setImg(dtoprojectos.getImg());
        projectos.setFecha(dtoprojectos.getFecha());
        projectos.setUrl(dtoprojectos.getUrl());

        imProjectosService.save(projectos);
        return new ResponseEntity(new Mensaje("Projecto actualizado"), HttpStatus.OK);
    }
}
