package com.portfolio.ferq.Service;

import com.portfolio.ferq.Entity.DescAcercaDe;
import com.portfolio.ferq.Repository.IDescAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpDescAcercaDeService {

    @Autowired
    IDescAcercaDe iDescAcercaDe;

    public List<DescAcercaDe> list() {
        return iDescAcercaDe.findAll();
    }

    public Optional<DescAcercaDe> getOne(int id) {
        return iDescAcercaDe.findById(id);
    }

    public Optional<DescAcercaDe> getByDescripcion(String descripcion) {
        return iDescAcercaDe.findByDescripcion(descripcion);
    }

    public void save(DescAcercaDe descAcercaDe) {
        iDescAcercaDe.save(descAcercaDe);
    }

    public void delete(int id) {
        iDescAcercaDe.deleteById(id);
    }

    public boolean existsById(int id) {
        return iDescAcercaDe.existsById(id);
    }

    public boolean existsByDescripcion(String descripcion) {
        return iDescAcercaDe.existsByDescripcion(descripcion);
    }
}
