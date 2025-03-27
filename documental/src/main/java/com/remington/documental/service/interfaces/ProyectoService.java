package com.remington.documental.service.interfaces;

import com.remington.documental.model.Proyecto;

import java.util.List;

public interface ProyectoService {
    void crear(Proyecto proyecto);
    List<Proyecto> listar();
    void editar(Proyecto proyecto);
    void eliminar(Long id);
}
