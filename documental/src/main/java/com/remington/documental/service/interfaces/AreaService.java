package com.remington.documental.service.interfaces;

import com.remington.documental.model.Area;

import java.util.List;

public interface AreaService {

    void crear(Area area);
    List<Area> listar();
    void editar(Area area);
    void eliminar(Long id);
}
