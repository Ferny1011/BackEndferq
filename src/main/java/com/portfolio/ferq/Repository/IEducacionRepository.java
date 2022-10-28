package com.portfolio.ferq.Repository;

import com.portfolio.ferq.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Integer>{
    public Optional<Educacion> findByTituloE(String tituloE);
    public boolean existsByTituloE(String tituloE);
}
