package com.remington.documental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String version;
    private LocalDateTime fechaInscripcion;
    private Integer numeroIntegrantes;


    @ManyToOne
    @JoinColumn(name = "convocatoria_id", referencedColumnName = "id")
    private Convocatoria convocatoria;
    @ManyToOne
    @JoinColumn(name = "semillero_id", referencedColumnName = "id")
    private Semillero semillero;
    @ManyToOne
    @JoinColumn(name = "fase_proyecto_id", referencedColumnName = "id")
    private FaseProyecto faseProyecto;
    @ManyToOne
    @JoinColumn(name = "sede_id", referencedColumnName = "id")
    private Sede sede;
    @ManyToOne
    @JoinColumn(name = "programa_academico_id", referencedColumnName = "id")
    private ProgramaAcademico programaAcademico;
    @ManyToOne
    @JoinColumn(name = "facultad_id", referencedColumnName = "id")
    private Facultad facultad;
    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;
    private String estado;

}
