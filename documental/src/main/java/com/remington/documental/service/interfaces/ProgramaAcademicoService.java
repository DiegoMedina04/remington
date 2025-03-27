package com.remington.documental.service.interfaces;

import com.remington.documental.model.ProgramaAcademico;

import java.util.List;

public interface ProgramaAcademicoService {
    void crear(ProgramaAcademico programaAcademico);
    List<ProgramaAcademico> listar();
    void editar(ProgramaAcademico programaAcademico);
    void eliminar(Long id);
}
