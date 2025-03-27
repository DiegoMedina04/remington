package com.remington.documental.service.interfaces;

import com.remington.documental.model.ProyectoEstudiante;

import java.util.List;

public interface ProyectoEstudianteService {
    void crear(ProyectoEstudiante proyectoEstudiante);
    List<ProyectoEstudiante> listar();
    void editar(ProyectoEstudiante proyectoEstudiante);
    void eliminar(Long id);
}
