package com.remington.documental.service;

import com.remington.documental.model.Sede;
import com.remington.documental.repository.SedeRepository;
import com.remington.documental.service.interfaces.SedeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;

    public SedeServiceImpl(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @Override
    public void crear(Sede sede) {
        sedeRepository.save(sede);
    }

    @Override
    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    @Override
    public void editar(Sede sede) {
        sedeRepository.save(sede);
    }

    @Override
    public void eliminar(Long id) {
        sedeRepository.deleteById(id);
    }
}
