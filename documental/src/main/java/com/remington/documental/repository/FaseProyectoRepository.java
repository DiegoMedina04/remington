package com.remington.documental.repository;

import com.remington.documental.model.FaseProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseProyectoRepository extends JpaRepository<FaseProyecto, Long> {
}
