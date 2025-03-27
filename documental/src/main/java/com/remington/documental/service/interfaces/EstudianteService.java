package com.remington.documental.service.interfaces;

import com.remington.documental.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    void crear(Estudiante estudiante);
    List<Estudiante> listar();
    void editar(Estudiante estudiante);
    void eliminar(Long id);
}
