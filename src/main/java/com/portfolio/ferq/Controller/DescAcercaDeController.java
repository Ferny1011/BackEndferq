package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoDescAcercaDe;
import com.portfolio.ferq.Entity.DescAcercaDe;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpDescAcercaDeService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dabout")
@CrossOrigin(origins = {"https://frontendferq.web.app", "http://localhost:4200"})
public class DescAcercaDeController {

    @Autowired
    ImpDescAcercaDeService impDescAcercaDeService;

    @GetMapping("/lista")
    public ResponseEntity<List<DescAcercaDe>> list() {
        List<DescAcercaDe> list = impDescAcercaDeService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<DescAcercaDe> getById(@PathVariable("id") int id) {
        if (!impDescAcercaDeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        DescAcercaDe descAcercaDe = impDescAcercaDeService.getOne(id).get();
        return new ResponseEntity(descAcercaDe, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDescAcercaDe dtodescAcercaDe) {
        if (!impDescAcercaDeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (impDescAcercaDeService.existsByDescripcion(dtodescAcercaDe.getDescripcion()) && impDescAcercaDeService.getByDescripcion(dtodescAcercaDe.getDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa descripcion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtodescAcercaDe.getDescripcion())) {
            return new ResponseEntity(new Mensaje("El campo Descripcion no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        DescAcercaDe descAcercaDe = impDescAcercaDeService.getOne(id).get();
        descAcercaDe.setDescripcion(dtodescAcercaDe.getDescripcion());
        impDescAcercaDeService.save(descAcercaDe);
        return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
    }

}
