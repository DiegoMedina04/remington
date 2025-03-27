package com.remington.documental.service;

import com.remington.documental.model.Facultad;
import com.remington.documental.repository.FacultadRepository;
import com.remington.documental.service.interfaces.FacultadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadServiceImpl implements FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadServiceImpl(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    public void crear(Facultad facultad) {
        facultadRepository.save(facultad);
    }

    @Override
    public List<Facultad> listar() {
        return facultadRepository.findAll();
    }

    @Override
    public void editar(Facultad facultad) {
        facultadRepository.save(facultad);
    }

    @Override
    public void eliminar(Long id) {
        facultadRepository.deleteById(id);
    }
}
