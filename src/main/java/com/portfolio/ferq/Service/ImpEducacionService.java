package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.Educacion;
import com.portfolio.ferq.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    @Autowired
    IEducacionRepository ieducacionRepository;
    
    public List<Educacion> list(){
        return ieducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return ieducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByTituloE(String tituloE){
        return ieducacionRepository.findByTituloE(tituloE);
    }
    
    public void save(Educacion educacion){
        ieducacionRepository.save(educacion);
    }
    
    public void delete(int id){
        ieducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ieducacionRepository.existsById(id);
    }
    
    public boolean existByTituloE(String tituloE){
        return ieducacionRepository.existsByTituloE(tituloE);
    }
}
