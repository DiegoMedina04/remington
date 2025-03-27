package com.remington.documental.service;

import com.remington.documental.model.ProyectoAsesor;
import com.remington.documental.repository.ProyectoAsesorRepository;
import com.remington.documental.service.interfaces.ProyectoAsesorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoAsesorServiceImpl implements ProyectoAsesorService {

    private final ProyectoAsesorRepository proyectoAsesorRepository;

    public ProyectoAsesorServiceImpl(ProyectoAsesorRepository proyectoAsesorRepository) {
        this.proyectoAsesorRepository = proyectoAsesorRepository;
    }


    @Override
    public void crear(ProyectoAsesor proyectoAsesor) {
        proyectoAsesorRepository.save(proyectoAsesor);
    }

    @Override
    public List<ProyectoAsesor> listar() {
        return proyectoAsesorRepository.findAll();
    }

    @Override
    public void editar(ProyectoAsesor proyectoAsesor) {
        proyectoAsesorRepository.save(proyectoAsesor);
    }

    @Override
    public void eliminar(Long id) {
        proyectoAsesorRepository.deleteById(id);
    }
}
