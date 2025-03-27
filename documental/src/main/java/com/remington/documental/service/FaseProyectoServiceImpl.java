package com.remington.documental.service;

import com.remington.documental.model.FaseProyecto;
import com.remington.documental.repository.FaseProyectoRepository;
import com.remington.documental.service.interfaces.FaseProyectoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseProyectoServiceImpl implements FaseProyectoService {

    private final FaseProyectoRepository faseProyectoRepository;

    public FaseProyectoServiceImpl(FaseProyectoRepository faseProyectoRepository) {
        this.faseProyectoRepository = faseProyectoRepository;
    }

    @Override
    public void crear(FaseProyecto faseProyecto) {
        faseProyectoRepository.save(faseProyecto);
    }

    @Override
    public List<FaseProyecto> listar() {
        return faseProyectoRepository.findAll();
    }

    @Override
    public void editar(FaseProyecto faseProyecto) {
        faseProyectoRepository.save(faseProyecto);
    }

    @Override
    public void eliminar(Long id) {
        faseProyectoRepository.deleteById(id);
    }
}
