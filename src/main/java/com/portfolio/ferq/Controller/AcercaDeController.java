package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoAcercaDe;
import com.portfolio.ferq.Entity.AcercaDe;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpAcercaDeService;
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
@RequestMapping("/about")
@CrossOrigin(origins = {"https://frontendferq.web.app", "http://localhost:4200"})
public class AcercaDeController {

    @Autowired
    ImpAcercaDeService impAcercaDeService;

    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list() {
        List<AcercaDe> list = impAcercaDeService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id") int id) {
        if (!impAcercaDeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        AcercaDe acercaDe = impAcercaDeService.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impAcercaDeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impAcercaDeService.delete(id);
        return new ResponseEntity(new Mensaje("Elemento eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoacercaDe) {
        if (StringUtils.isBlank(dtoacercaDe.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoacercaDe.getSubtitulo())) {
            return new ResponseEntity(new Mensaje("El subtitulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoacercaDe.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        if (impAcercaDeService.existsByTitulo(dtoacercaDe.getTitulo())) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = new AcercaDe(dtoacercaDe.getTitulo(), dtoacercaDe.getSubtitulo(), dtoacercaDe.getImg());
        impAcercaDeService.save(acercaDe);
        return new ResponseEntity(new Mensaje("Elemento creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercaDe) {
        if (!impAcercaDeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (impAcercaDeService.existsByTitulo(dtoacercaDe.getTitulo()) && impAcercaDeService.getByTitulo(dtoacercaDe.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoacercaDe.getTitulo())) {
            return new ResponseEntity(new Mensaje("El campo titulo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoacercaDe.getSubtitulo())) {
            return new ResponseEntity(new Mensaje("El campo subtitulo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoacercaDe.getImg())) {
            return new ResponseEntity(new Mensaje("El campo Imagen no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        AcercaDe acercaDe = impAcercaDeService.getOne(id).get();
        acercaDe.setTitulo(dtoacercaDe.getTitulo());
        acercaDe.setSubtitulo(dtoacercaDe.getSubtitulo());
        acercaDe.setImg(dtoacercaDe.getImg());

        impAcercaDeService.save(acercaDe);
        return new ResponseEntity(new Mensaje("Elemento actualizado"), HttpStatus.OK);
    }
}
