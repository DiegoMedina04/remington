package com.remington.documental.service;

import com.remington.documental.model.Convocatoria;
import com.remington.documental.repository.ConvocatoriaRepository;
import com.remington.documental.service.interfaces.ConvocatoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {

    private final ConvocatoriaRepository convocatoriaRepository;

    public ConvocatoriaServiceImpl(ConvocatoriaRepository convocatoriaRepository) {
        this.convocatoriaRepository = convocatoriaRepository;
    }


    @Override
    public void crear(Convocatoria convocatoria) {
        convocatoriaRepository.save(convocatoria);
    }

    @Override
    public List<Convocatoria> listar() {
        return convocatoriaRepository.findAll();
    }

    @Override
    public void editar(Convocatoria convocatoria) {
        convocatoriaRepository.save(convocatoria);
    }

    @Override
    public void eliminar(Long id) {
        convocatoriaRepository.deleteById(id);
    }
}
