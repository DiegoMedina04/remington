package com.remington.documental.controller;

import com.remington.documental.model.Facultad;
import com.remington.documental.model.FaseProyecto;
import com.remington.documental.service.FacultadServiceImpl;
import com.remington.documental.service.FaseProyectoServiceImpl;
import com.remington.documental.service.interfaces.FaseProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faseProyecto")
@Tag(name = "FaseProyecto", description = "La API de Fase Proyecto")
public class FaseProyectoController {


    @Autowired
    private FaseProyectoServiceImpl faseProyectoService;

    @Operation(summary = "Crear una fase de proyecto", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Fase de proyecto inválida"), @ApiResponse(responseCode = "404", description = "Fase de proyecto no encontrada")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto fase de proyecto que necesita ser agregado al sistema.") FaseProyecto faseProyecto) {
        faseProyectoService.crear(faseProyecto);
    }

    @Operation(summary = "Listar todos las facultades", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Fase de proyecto no encontrada")})

    @GetMapping
    public List<FaseProyecto> listar() {
        return faseProyectoService.listar();
    }

    @Operation(summary = "Actualizar una fase de proyecto", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Fase de proyecto inválida"), @ApiResponse(responseCode = "404", description = "Fase de proyecto no encontrada")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto fase del proyecto que necesita ser actualizado en el sistema.") FaseProyecto faseProyecto) {
        faseProyectoService.editar(faseProyecto);
    }

    @Operation(summary = "Eliminar una fase de proyecto existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Fase de proyecto no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID de la fase de proyecto que necesita ser eliminado.") Long id) {
        faseProyectoService.eliminar(id);
    }

}
