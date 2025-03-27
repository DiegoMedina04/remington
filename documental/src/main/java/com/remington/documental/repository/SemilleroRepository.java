package com.remington.documental.repository;

import com.remington.documental.model.Semillero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemilleroRepository extends JpaRepository<Semillero, Long> {
}
