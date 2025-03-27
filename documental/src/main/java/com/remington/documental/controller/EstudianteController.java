package com.remington.documental.controller;

import com.remington.documental.model.Convocatoria;
import com.remington.documental.model.Estudiante;
import com.remington.documental.service.ConvocatoriaServiceImpl;
import com.remington.documental.service.EstudianteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;
@RestController
@RequestMapping("/estudiante")
@Tag(name = "Estudiante", description = "La API de Estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteServiceImpl estudianteService;

    @Operation(summary = "Crear un nuevo estudiante", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Estudiante inválido"), @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto estudiante que necesita ser agregado al sistema.") Estudiante estudiante) {
       estudianteService.crear(estudiante);
    }

    @Operation(summary = "Listar todos los estudiantes", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")})

    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listar();
    }

    @Operation(summary = "Actualizar un estudiante", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Estudiante inválido"), @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto estudainte que necesita ser actualizado en el sistema.") Estudiante estudiante) {
        estudianteService.editar(estudiante);
    }

    @Operation(summary = "Eliminar un estudiante existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del estudiante que necesita ser eliminado.") Long id) {
        estudianteService.eliminar(id);
    }

}
