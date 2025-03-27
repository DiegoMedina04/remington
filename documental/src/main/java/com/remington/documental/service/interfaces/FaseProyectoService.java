package com.remington.documental.service.interfaces;

import com.remington.documental.model.FaseProyecto;

import java.util.List;

public interface FaseProyectoService {
    void crear(FaseProyecto faseProyecto);
    List<FaseProyecto> listar();
    void editar(FaseProyecto faseProyecto);
    void eliminar(Long id);
}
