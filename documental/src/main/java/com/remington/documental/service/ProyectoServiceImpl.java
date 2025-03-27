package com.remington.documental.service;

import com.remington.documental.model.Proyecto;
import com.remington.documental.repository.ProyectoRepository;
import com.remington.documental.service.interfaces.ProyectoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {


    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public void crear(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> listar() {
        return proyectoRepository.findAll();
    }

    @Override
    public void editar(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void eliminar(Long id) {
        proyectoRepository.deleteById(id);
    }
}
