package com.remington.documental.service.interfaces;


import com.remington.documental.model.Facultad;

import java.util.List;

public interface FacultadService {
    void crear(Facultad facultad);
    List<Facultad> listar();
    void editar(Facultad facultad);
    void eliminar(Long id);
}
