package com.portfolio.ferq.Repository;

import com.portfolio.ferq.Entity.Projectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectosRepository extends JpaRepository<Projectos,Integer> {
    public Optional<Projectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
