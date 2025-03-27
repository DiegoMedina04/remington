package com.remington.documental.service;

import com.remington.documental.model.ProyectoEstudiante;
import com.remington.documental.repository.ProyectoEstudianteRepository;
import com.remington.documental.service.interfaces.ProyectoEstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoEstudianteServiceImpl implements ProyectoEstudianteService {

    private final ProyectoEstudianteRepository proyectoEstudianteRepository;

    public ProyectoEstudianteServiceImpl(ProyectoEstudianteRepository proyectoEstudianteRepository) {
        this.proyectoEstudianteRepository = proyectoEstudianteRepository;
    }


    @Override
    public void crear(ProyectoEstudiante proyectoEstudiante) {
        proyectoEstudianteRepository.save(proyectoEstudiante);
    }

    @Override
    public List<ProyectoEstudiante> listar() {
        return proyectoEstudianteRepository.findAll();
    }

    @Override
    public void editar(ProyectoEstudiante proyectoEstudiante) {
        proyectoEstudianteRepository.save(proyectoEstudiante);
    }

    @Override
    public void eliminar(Long id) {
        proyectoEstudianteRepository.deleteById(id);
    }
}
