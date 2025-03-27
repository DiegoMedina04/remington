package com.remington.documental.repository;

import com.remington.documental.model.ProyectoAsesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoAsesorRepository extends JpaRepository<ProyectoAsesor, Long> {
}
