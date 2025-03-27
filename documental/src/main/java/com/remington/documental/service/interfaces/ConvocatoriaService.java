package com.remington.documental.service.interfaces;

import com.remington.documental.model.Convocatoria;

import java.util.List;

public interface ConvocatoriaService {
    void crear(Convocatoria convocatoria);
    List<Convocatoria> listar();
    void editar(Convocatoria convocatoria);
    void eliminar(Long id);
}
