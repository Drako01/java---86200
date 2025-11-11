package com.coderhouse.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "DTO de Inscripciones de Alumnos a Cursos")
public class InscripcionAlumnoDTO {

	@Schema(description = "ID del Alumno", example = "1")
	private Long alumnoId;

	@Schema(description = "IDs del Cursos disponibles", example = "[1,2,3]")
	private List<Long> cursoIds;
}
