package com.remington.documental.controller;

import com.remington.documental.model.Proyecto;
import com.remington.documental.service.ProyectoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@Tag(name = "Proyecto", description = "La API de Proyecto")
public class ProyectoController {


    private final ProyectoServiceImpl proyectoService;

    public ProyectoController(ProyectoServiceImpl proyectoService) {
        this.proyectoService = proyectoService;
    }

    @Operation(summary = "Crear un Proyecto Asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto Asesor inválido"),
            @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true,
            description = "El objeto programa cadémico que necesita ser agregado al sistema.") Proyecto proyecto) {
        proyectoService.crear(proyecto);
    }

    @Operation(summary = "Listar todos los proyectos asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})

    @GetMapping
    public List<Proyecto> listar() {
        return    proyectoService.listar();
    }

    @Operation(summary = "Actualizar un Proyecto Asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Proyecto Asesor inválido"),
            @ApiResponse(responseCode = "404", description = "Proyecto Asesor no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto Proyecto asesor que necesita ser actualizado en el sistema.")
                           Proyecto proyecto) {
        proyectoService.editar(proyecto);
    }


}
