package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.Experiencia;
import com.portfolio.ferq.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
    IExperienciaRepository iexperienciaRepository;
    
    public List<Experiencia> List(){
        return iexperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iexperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return iexperienciaRepository.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        iexperienciaRepository.save(expe);
    }
    
    public void delete(int id){
        iexperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iexperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return iexperienciaRepository.existsByNombreE(nombreE);
    }
    
}
