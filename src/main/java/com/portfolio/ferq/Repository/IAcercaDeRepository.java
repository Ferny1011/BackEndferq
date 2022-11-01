package com.portfolio.ferq.Repository;

import com.portfolio.ferq.Entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeRepository extends JpaRepository<AcercaDe,Integer>{
    public Optional<AcercaDe> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
