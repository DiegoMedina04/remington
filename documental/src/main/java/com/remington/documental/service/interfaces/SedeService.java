package com.remington.documental.service.interfaces;

import com.remington.documental.model.Sede;

import java.util.List;

public interface SedeService {
    void crear(Sede sede);
    List<Sede> listar();
    void editar(Sede sede);
    void eliminar(Long id);
}
