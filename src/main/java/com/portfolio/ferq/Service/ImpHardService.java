package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.HardSkills;
import com.portfolio.ferq.Repository.IHardRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpHardService {
    @Autowired
    IHardRepository iHardRepository;
    
        public List<HardSkills> list(){
        return iHardRepository.findAll();
    }
    public Optional<HardSkills> getOne(int id){
        return iHardRepository.findById(id);
    }
    
    public Optional<HardSkills> getByNombre(String nombre){
        return iHardRepository.findByNombre(nombre);
    }
    
    public void save(HardSkills hardSkills){
        iHardRepository.save(hardSkills);
    }
    
    public void delete(int id){
        iHardRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iHardRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iHardRepository.existsByNombre(nombre);
    }
    
}
