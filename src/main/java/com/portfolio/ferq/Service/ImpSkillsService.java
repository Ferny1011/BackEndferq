package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.Skills;
import com.portfolio.ferq.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpSkillsService {
    @Autowired
    ISkillsRepository iSkillsRepository;
    
    public List<Skills> list(){
        return iSkillsRepository.findAll();
    }
    public Optional<Skills> getOne(int id){
        return iSkillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return iSkillsRepository.findByNombre(nombre);
    }
    
    public void save(Skills skill){
        iSkillsRepository.save(skill);
    }
    
    public void delete(int id){
        iSkillsRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillsRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iSkillsRepository.existsByNombre(nombre);
    }
}

