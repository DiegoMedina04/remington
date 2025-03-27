package com.remington.documental.service;

import com.remington.documental.model.HistorialDocumento;
import com.remington.documental.repository.HistorialDocumentoRepository;
import com.remington.documental.service.interfaces.HistorialDocumentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialDocumentoServiceImpl implements HistorialDocumentoService {

    private final HistorialDocumentoRepository historialDocumentoRepository;

    public HistorialDocumentoServiceImpl(HistorialDocumentoRepository historialDocumentoRepository) {
        this.historialDocumentoRepository = historialDocumentoRepository;
    }

    @Override
    public void crear(HistorialDocumento historialDocumento) {
        historialDocumentoRepository.save(historialDocumento);
    }

    @Override
    public List<HistorialDocumento> listar() {
        return historialDocumentoRepository.findAll();
    }

    @Override
    public void editar(HistorialDocumento historialDocumento) {
        historialDocumentoRepository.save(historialDocumento);
    }

    @Override
    public void eliminar(Long id) {
        historialDocumentoRepository.deleteById(id);
    }
}
