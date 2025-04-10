package com.remington.documental.repository;

import com.remington.documental.model.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
}
