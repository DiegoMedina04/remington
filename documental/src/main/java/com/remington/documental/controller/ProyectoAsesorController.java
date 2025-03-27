package com.remington.documental.controller;

import com.remington.documental.model.ProgramaAcademico;
import com.remington.documental.model.ProyectoAsesor;
import com.remington.documental.service.ProgramaAcademicoServiceImpl;
import com.remington.documental.service.ProyectoAsesorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectoAsesor")
@Tag(name = "ProyectoAsesor", description = "La API de Proyecto asesor")


public class ProyectoAsesorController {


    @Autowired
    private ProyectoAsesorServiceImpl proyectoAsesorService;

    @Operation(summary = "Crear un Proyecto Asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto Asesor inválido"), @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto proyecto asesor que necesita ser agregado al sistema.") ProyectoAsesor proyectoAsesor) {
        proyectoAsesorService.crear(proyectoAsesor);
    }

    @Operation(summary = "Listar todos los proyectos asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})

    @GetMapping
    public List<ProyectoAsesor> listar() {
        return proyectoAsesorService.listar();
    }

    @Operation(summary = "Actualizar un Proyecto Asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto Asesor inválido"), @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto Proyecto asesor que necesita ser actualizado en el sistema.") ProyectoAsesor proyectoAsesor) {
        proyectoAsesorService.editar(proyectoAsesor);
    }

}
