package com.remington.documental.service.interfaces;

import com.remington.documental.model.HistorialDocumento;

import java.util.List;

public interface HistorialDocumentoService {
    void crear(HistorialDocumento historialDocumento);
    List<HistorialDocumento> listar();
    void editar(HistorialDocumento historialDocumento);
    void eliminar(Long id);
}
