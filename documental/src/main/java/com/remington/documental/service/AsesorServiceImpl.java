package com.remington.documental.service;

import com.remington.documental.model.Asesor;
import com.remington.documental.repository.AsesorRepository;
import com.remington.documental.service.interfaces.AsesorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsesorServiceImpl implements AsesorService {

    private final AsesorRepository asesorRepository;

    public AsesorServiceImpl(AsesorRepository asesorRepository) {
        this.asesorRepository = asesorRepository;
    }

    @Override
    public void crear(Asesor asesor) {
        asesorRepository.save(asesor);
    }

    @Override
    public List<Asesor> listar() {
        return asesorRepository.findAll();
    }

    @Override
    public void editar(Asesor asesor) {
        asesorRepository.save(asesor);
    }

    @Override
    public void eliminar(Long id) {

    }
}
