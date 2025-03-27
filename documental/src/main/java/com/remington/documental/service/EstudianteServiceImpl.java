package com.remington.documental.service;

import com.remington.documental.model.Estudiante;
import com.remington.documental.repository.EstudianteRepository;
import com.remington.documental.service.interfaces.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void crear(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public void editar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
