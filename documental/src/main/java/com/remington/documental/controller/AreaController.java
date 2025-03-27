package com.remington.documental.controller;

import com.remington.documental.model.Area;
import com.remington.documental.service.AreaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
@Tag(name = "Area", description = "La API de Area")
public class AreaController {

    @Autowired
    private AreaServiceImpl areaService;

    @Operation(summary = "Crear una nueva area", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "area inválida"), @ApiResponse(responseCode = "404", description = "area no encontrada")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto area que necesita ser agregado al sistema.") Area area) {
        areaService.crear(area);
    }

    @Operation(summary = "Listar todas las areas", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "area no encontrada")})
    @GetMapping
    public List<Area> listar() {
        return areaService.listar();
    }

    @Operation(summary = "Actualizar un area existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "area inválida"), @ApiResponse(responseCode = "404", description = "area no encontrada")})
    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto area que necesita ser actualizado en el sistema.") Area area) {
        areaService.editar(area);
    }

    @Operation(summary = "Eliminar un area existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "area no encontrada")})
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del area que necesita ser eliminado.") Long id) {
        areaService.eliminar(id);
    }

}
