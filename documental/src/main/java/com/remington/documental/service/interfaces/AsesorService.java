package com.remington.documental.service.interfaces;

import com.remington.documental.model.Asesor;

import java.util.List;

public interface AsesorService {
    void crear(Asesor asesor);
    List<Asesor> listar();
    void editar(Asesor asesor);
    void eliminar(Long id);
}
