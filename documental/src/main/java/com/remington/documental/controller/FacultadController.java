package com.remington.documental.controller;

import com.remington.documental.model.Estudiante;
import com.remington.documental.model.Facultad;
import com.remington.documental.service.EstudianteServiceImpl;
import com.remington.documental.service.FacultadServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/facultad")
@Tag(name = "Faccultad", description = "La API de Facultad")
public class FacultadController {

    @Autowired
    private FacultadServiceImpl facultadService;

    @Operation(summary = "Crear una nueva facultad", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "facultad inválida"), @ApiResponse(responseCode = "404", description = "facultad no encontrada")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto facultad que necesita ser agregado al sistema.") Facultad  facultad) {
        facultadService.crear(facultad);
    }

    @Operation(summary = "Listar todas las facultades", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Facultad no encontrado")})

    @GetMapping
    public List<Facultad> listar() {
        return facultadService.listar();
    }

    @Operation(summary = "Actualizar una facultad", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Facultad inválida"), @ApiResponse(responseCode = "404", description = "Facultad no encontrada")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto facultad que necesita ser actualizado en el sistema.") Facultad facultad) {
        facultadService.editar(facultad);
    }

    @Operation(summary = "Eliminar una facultad existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Facultad no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID de la facultad que necesita ser eliminado.") Long id) {
        facultadService.eliminar(id);
    }

}
