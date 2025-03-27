package com.remington.documental.controller;

import com.remington.documental.model.Asesor;
import com.remington.documental.model.Convocatoria;
import com.remington.documental.service.AsesorServiceImpl;
import com.remington.documental.service.ConvocatoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/convocatoria")
@Tag(name = "convocatoria", description = "La API de Convoatoria")
public class ConvocatoriaController {
    @Autowired
    private ConvocatoriaServiceImpl convocatoriaService;

    @Operation(summary = "Crear una nuevo concocatoria", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "asesor inválida"), @ApiResponse(responseCode = "404", description = "Convocatoria no encontrada")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto concocatoria que necesita ser agregado al sistema.") Convocatoria convocatoria) {
        convocatoriaService.crear(convocatoria);
    }

    @Operation(summary = "Listar todas las convocatorias", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Convocatoria no encontrada")})

    @GetMapping
    public List<Convocatoria> listar() {
        return convocatoriaService.listar();
    }

    @Operation(summary = "Actualizar una convocatoria", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Convocatoria inválido"), @ApiResponse(responseCode = "404", description = "Convocatoria no encontrada")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto convocatoria que necesita ser actualizado en el sistema.") Convocatoria convocatoria) {
        convocatoriaService.editar(convocatoria);
    }

    @Operation(summary = "Eliminar una convocatoria existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Convocatoria no encontrada")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID de la convocatoria que necesita ser eliminado.") Long id) {
        convocatoriaService.eliminar(id);
    }

}
