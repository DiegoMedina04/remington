package com.remington.documental.service;

import com.remington.documental.model.ProgramaAcademico;
import com.remington.documental.repository.ProgramaAcademicoRepository;
import com.remington.documental.service.interfaces.ProgramaAcademicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaAcademicoServiceImpl implements ProgramaAcademicoService {

    private final ProgramaAcademicoRepository programaAcademicoRepository;

    public ProgramaAcademicoServiceImpl(ProgramaAcademicoRepository programaAcademicoRepository) {
        this.programaAcademicoRepository = programaAcademicoRepository;
    }

    @Override
    public void crear(ProgramaAcademico programaAcademico) {
        programaAcademicoRepository.save(programaAcademico);
    }

    @Override
    public List<ProgramaAcademico> listar() {
        return programaAcademicoRepository.findAll();
    }

    @Override
    public void editar(ProgramaAcademico programaAcademico) {
        programaAcademicoRepository.save(programaAcademico);
    }

    @Override
    public void eliminar(Long id) {
        programaAcademicoRepository.deleteById(id);
    }
}
