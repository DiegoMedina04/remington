package com.remington.documental.service.interfaces;

import com.remington.documental.model.ProyectoAsesor;

import java.util.List;

public interface ProyectoAsesorService {
    void crear(ProyectoAsesor proyectoAsesor);
    List<ProyectoAsesor> listar();
    void editar(ProyectoAsesor proyectoAsesor);
    void eliminar(Long id);
}
