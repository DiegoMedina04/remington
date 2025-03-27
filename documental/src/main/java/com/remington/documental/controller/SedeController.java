package com.remington.documental.controller;

import com.remington.documental.model.Area;
import com.remington.documental.model.Sede;
import com.remington.documental.service.AreaServiceImpl;
import com.remington.documental.service.SedeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sede")
@Tag(name = "Sede", description = "La API de Sede")

public class SedeController {
    @Autowired
    private SedeServiceImpl sedeService;

    @Operation(summary = "Crear una nueva sede", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Sede inválida"), @ApiResponse(responseCode = "404", description = "Sede no encontrada")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto sede que necesita ser agregado al sistema.") Sede sede) {
        sedeService.crear(sede);
    }

    @Operation(summary = "Listar todas las sedes", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "sede no encontrada")})
    @GetMapping
    public List<Sede> listar() {
        return sedeService.listar();
    }

    @Operation(summary = "Actualizar un sede existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "sede inválida"), @ApiResponse(responseCode = "404", description = "sede no encontrada")})
    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto sede que necesita ser actualizado en el sistema.") Sede sede) {
        sedeService.editar(sede);
    }

    @Operation(summary = "Eliminar una sede existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Sede no encontrada")})
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del sede que necesita ser eliminado.") Long id) {
        sedeService.eliminar(id);
    }

}
