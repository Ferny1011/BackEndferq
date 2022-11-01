package com.portfolio.ferq.Repository;

import com.portfolio.ferq.Entity.DescAcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDescAcercaDe extends JpaRepository<DescAcercaDe,Integer> {
    public Optional<DescAcercaDe> findByDescripcion(String descripcion);
    public boolean existsByDescripcion(String descripcion);
    
}
