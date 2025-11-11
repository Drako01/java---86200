package com.coderhouse.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "DTO de Inscripciones de Alumnos a Cursos", requiredProperties = {"alumnoId","cursoIds"})
public class InscripcionAlumnoDTO {

	@Schema(description = "ID del Alumno", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long alumnoId;

	@Schema(description = "IDs del Cursos disponibles", requiredMode = Schema.RequiredMode.REQUIRED)
	@ArraySchema(minItems = 1, uniqueItems = true, schema = @Schema(implementation = Long.class, example = "1"))
	private List<Long> cursoIds;
}
