package com.remington.documental.controller;
import com.remington.documental.model.Asesor;
import com.remington.documental.service.AreaServiceImpl;
import com.remington.documental.service.AsesorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asesor")
@Tag(name = "Asesor", description = "La API de Asesor")
public class AsesorController {

    @Autowired
    private AsesorServiceImpl asesorService;

    @Operation(summary = "Crear una nuevo asesor", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "asesor inválida"), @ApiResponse(responseCode = "404", description = "Asesor no encontrado")})
    @PostMapping
    public void crear(@RequestBody @Schema(required = true, description = "El objeto asesor que necesita ser agregado al sistema.") Asesor asesor) {
        asesorService.crear(asesor);
    }

    @Operation(summary = "Listar todas las asesores", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "asesor no encontrado")})

    @GetMapping
    public List<Asesor> listar() {
        return asesorService.listar();
    }

    @Operation(summary = "Actualizar un area existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Asesor inválido"), @ApiResponse(responseCode = "404", description = "Asesor no encontrado")})

    @PutMapping
    public void editar(@RequestBody @Schema(required = true, description = "El objeto area que necesita ser actualizado en el sistema.") Asesor asesor) {
        asesorService.editar(asesor);
    }

    @Operation(summary = "Eliminar un asesor existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Asesor no encontrado")})

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @Schema(required = true, description = "ID del asesor que necesita ser eliminado.") Long id) {
        asesorService.eliminar(id);
    }

}
