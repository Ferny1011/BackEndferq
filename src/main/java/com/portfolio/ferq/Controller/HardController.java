
package com.portfolio.ferq.Controller;

import com.portfolio.ferq.Dto.dtoHard;
import com.portfolio.ferq.Entity.HardSkills;
import com.portfolio.ferq.Security.Controller.Mensaje;
import com.portfolio.ferq.Service.ImpHardService;
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
@CrossOrigin(origins = {"https://frontendferq.web.app","http://localhost:4200"})
@RequestMapping("/hard")
public class HardController {
    @Autowired
    ImpHardService impHardService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardSkills>> list() {
        List<HardSkills> list = impHardService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkills> getById(@PathVariable("id") int id) {
        if (!impHardService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        HardSkills hardSkills = impHardService.getOne(id).get();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impHardService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        impHardService.delete(id);
        return new ResponseEntity(new Mensaje("Elemento eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHard dtohard) {
        if (StringUtils.isBlank(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtohard.getURLimg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (impHardService.existsByNombre(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        HardSkills hardSkills = new HardSkills(dtohard.getNombre(), dtohard.getPorcentaje(), dtohard.getURLimg());
        impHardService.save(hardSkills);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHard dtohard) {
        if (!impHardService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impHardService.existsByNombre(dtohard.getNombre()) && impHardService.getByNombre(dtohard.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtohard.getURLimg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        HardSkills hardskill = impHardService.getOne(id).get();
        hardskill.setNombre(dtohard.getNombre());
        hardskill.setPorcentaje(dtohard.getPorcentaje());
        hardskill.setURLimg(dtohard.getURLimg());

        impHardService.save(hardskill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}
