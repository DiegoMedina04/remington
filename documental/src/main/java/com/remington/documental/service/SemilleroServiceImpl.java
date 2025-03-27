package com.remington.documental.service;

import com.remington.documental.model.Semillero;
import com.remington.documental.repository.SemilleroRepository;
import com.remington.documental.service.interfaces.SemilleroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemilleroServiceImpl implements SemilleroService {

    private final SemilleroRepository semilleroRepository;

    public SemilleroServiceImpl(SemilleroRepository semilleroRepository) {
        this.semilleroRepository = semilleroRepository;
    }

    @Override
    public void crear(Semillero semillero) {
        semilleroRepository.save(semillero);
    }

    @Override
    public List<Semillero> listar() {
        return semilleroRepository.findAll();
    }

    @Override
    public void editar(Semillero semillero) {
        semilleroRepository.save(semillero);
    }

    @Override
    public void eliminar(Long id) {
        semilleroRepository.deleteById(id);
    }
}
