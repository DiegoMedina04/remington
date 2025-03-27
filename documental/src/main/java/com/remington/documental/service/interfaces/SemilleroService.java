package com.remington.documental.service.interfaces;

import com.remington.documental.model.Semillero;

import java.util.List;

public interface SemilleroService {
    void crear(Semillero semillero);
    List<Semillero> listar();
    void editar(Semillero semillero);
    void eliminar(Long id);
}
