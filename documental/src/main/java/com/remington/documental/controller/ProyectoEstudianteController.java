package com.remington.documental.controller;

import com.remington.documental.model.ProyectoAsesor;
import com.remington.documental.model.ProyectoEstudiante;
import com.remington.documental.service.ProyectoAsesorServiceImpl;
import com.remington.documental.service.ProyectoEstudianteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectoEstudiante")
@Tag(name = "ProyectoEstudiante", description = "La API de Proyecto estudiante")

public class ProyectoEstudianteController {

    @Autowired
    private ProyectoEstudianteServiceImpl proyectoEstudianteService;

    @Operation(summary = "Crear un Proyecto Estudiante", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto estudiante inválido"), @ApiResponse(responseCode = "404", description = "Proyecto estudiabte no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto pproyecto estudiante que necesita ser agregado al sistema.") ProyectoEstudiante proyectoEstudiante) {
        proyectoEstudianteService.crear(proyectoEstudiante);
    }

    @Operation(summary = "Listar todos los proyectos estudiante", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Proyecto estudiante no encontrado")})

    @GetMapping
    public List<ProyectoEstudiante> listar() {
        return proyectoEstudianteService.listar();
    }

    @Operation(summary = "Actualizar un Proyecto estudiante", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto estudiante inválido"), @ApiResponse(responseCode = "404", description = "Proyecto estudiante no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto Proyecto estudiante que necesita ser actualizado en el sistema.") ProyectoEstudiante proyectoEstudiante) {
        proyectoEstudianteService.editar(proyectoEstudiante);
    }


}
