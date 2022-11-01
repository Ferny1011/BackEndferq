package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.Projectos;
import com.portfolio.ferq.Repository.IProjectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProjectosService {
    @Autowired
    IProjectosRepository iProjectosRepository;
    
    public List<Projectos> list(){
        return iProjectosRepository.findAll();
    }
    
    public Optional<Projectos> getOne(int id){
        return iProjectosRepository.findById(id);
    }
    
    public Optional<Projectos> getByNombre(String nombre){
        return iProjectosRepository.findByNombre(nombre);
    }
    
    public void save(Projectos projectos){
       iProjectosRepository.save(projectos);
    }
    
    public void delete(int id){
        iProjectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProjectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iProjectosRepository.existsByNombre(nombre);
    }
}
