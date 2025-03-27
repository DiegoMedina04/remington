package com.remington.documental.service;

import com.remington.documental.model.Area;
import com.remington.documental.repository.AreaRepository;
import com.remington.documental.service.interfaces.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public void crear(Area area) {
        areaRepository.save(area);
    }

    @Override
    public List<Area> listar() {
        return areaRepository.findAll();
    }

    @Override
    public void editar(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void eliminar(Long id) {
        areaRepository.deleteById(id);
    }
}
