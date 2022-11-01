package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.AcercaDe;
import com.portfolio.ferq.Repository.IAcercaDeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpAcercaDeService {

    @Autowired
    IAcercaDeRepository iAcercaDeRepository;

    public List<AcercaDe> list() {
        return iAcercaDeRepository.findAll();
    }

    public Optional<AcercaDe> getOne(int id) {
        return iAcercaDeRepository.findById(id);
    }

    public Optional<AcercaDe> getByTitulo(String titulo) {
        return iAcercaDeRepository.findByTitulo(titulo);
    }

    public void save(AcercaDe acercaDe) {
        iAcercaDeRepository.save(acercaDe);
    }

    public void delete(int id) {
        iAcercaDeRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iAcercaDeRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return iAcercaDeRepository.existsByTitulo(titulo);
    }
}
