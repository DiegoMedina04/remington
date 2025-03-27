package com.remington.documental.controller;

import com.remington.documental.model.FaseProyecto;
import com.remington.documental.model.HistorialDocumento;
import com.remington.documental.service.FaseProyectoServiceImpl;
import com.remington.documental.service.HistorialDocumentoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historialDocumento")
@Tag(name = "HistorialDocumento", description = "La API de Historial de documento")

public class HistorialDocumentoController {

    @Autowired
    private HistorialDocumentoServiceImpl historialDocumentoService;

    @Operation(summary = "Crear un historial de documento", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Histrial de documento inválido"), @ApiResponse(responseCode = "404", description = "Historial de documento no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto historial de documento que necesita ser agregado al sistema.") HistorialDocumento historialDocumento) {
        historialDocumentoService.crear(historialDocumento);
    }

    @Operation(summary = "Listar todos los historiales de documentos", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Historial de documentos no encontrado")})

    @GetMapping
    public List<HistorialDocumento> listar() {
        return historialDocumentoService.listar();
    }

    @Operation(summary = "Actualizar un historial de documento", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Historial de documento inválido"), @ApiResponse(responseCode = "404", description = "Historial de documento no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto historial de documento que necesita ser actualizado en el sistema.") HistorialDocumento historialDocumento) {
        historialDocumentoService.editar(historialDocumento);
    }

    @Operation(summary = "Eliminar un historial de documento existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Historial de documento no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del historial de documento que necesita ser eliminado.") Long id) {
        historialDocumentoService.eliminar(id);
    }

}
