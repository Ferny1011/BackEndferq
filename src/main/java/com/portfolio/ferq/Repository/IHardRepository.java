package com.portfolio.ferq.Repository;

import com.portfolio.ferq.Entity.HardSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IHardRepository extends JpaRepository<HardSkills, Integer>{
    Optional<HardSkills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
