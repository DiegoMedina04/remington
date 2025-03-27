package com.remington.documental.controller;

import com.remington.documental.model.Sede;
import com.remington.documental.model.Semillero;
import com.remington.documental.service.SedeServiceImpl;
import com.remington.documental.service.SemilleroServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semillero")
@Tag(name = "Semillero", description = "La API de Semillero")

public class SemilleroController {

    @Autowired
    private SemilleroServiceImpl semilleroService;

    @Operation(summary = "Crear una nuevo semillero", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Semillero inválido"), @ApiResponse(responseCode = "404", description = "Semillero no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto semillero que necesita ser agregado al sistema.") Semillero semillero) {
        semilleroService.crear(semillero);
    }

    @Operation(summary = "Listar todas los semilleros", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "semillero no encontrado")})
    @GetMapping
    public List<Semillero> listar() {
        return semilleroService.listar();
    }

    @Operation(summary = "Actualizar un semillero existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Semillero inválido"), @ApiResponse(responseCode = "404", description = "semillero no encontrado")})
    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto semillero que necesita ser actualizado en el sistema.") Semillero semillero) {
        semilleroService.editar(semillero);
    }

    @Operation(summary = "Eliminar un semillero existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Semillero no encontrado")})
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del semillero que necesita ser eliminado.") Long id) {
        semilleroService.eliminar(id);
    }


}
