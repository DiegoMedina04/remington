package com.remington.documental.controller;

import com.remington.documental.model.HistorialDocumento;
import com.remington.documental.model.ProgramaAcademico;
import com.remington.documental.service.HistorialDocumentoServiceImpl;
import com.remington.documental.service.ProgramaAcademicoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/programaAcademico")
@Tag(name = "ProgramaAcademico", description = "La API de Programa académico")

public class ProgramaAcademicoController {

    @Autowired
    private ProgramaAcademicoServiceImpl programaAcademicoService;

    @Operation(summary = "Crear un programa académico", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Programa académico inválido"), @ApiResponse(responseCode = "404", description = "Programa academico no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto programa cadémico que necesita ser agregado al sistema.") ProgramaAcademico programaAcademico) {
       programaAcademicoService.crear(programaAcademico);
    }

    @Operation(summary = "Listar todos los programas académicos", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Programa académico no encontrado")})

    @GetMapping
    public List<ProgramaAcademico> listar() {
        return programaAcademicoService.listar();
    }

    @Operation(summary = "Actualizar un programa académico", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Programa académico inválido"), @ApiResponse(responseCode = "404", description = "Programa académico no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto programa académico que necesita ser actualizado en el sistema.") ProgramaAcademico programaAcademico) {
        programaAcademicoService.editar(programaAcademico);
    }

    @Operation(summary = "Eliminar un programa académico", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Programa académico no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del programa académico que necesita ser eliminado.") Long id) {
        programaAcademicoService.eliminar(id);
    }

}
