package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de Asignaci\u00f3n de Categoria a Cursos", requiredProperties = {"cursoId","categoriaId"})
public class AsignacionDeCategoriaACursoDTO {
	@Schema(description = "ID del Curso", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long cursoId;
	@Schema(description = "ID del Categoria", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long categoriaId;
}
