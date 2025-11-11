package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de Asignacion de Categoria a Cursos")
public class AsignacionDeCategoriaACursoDTO {
	@Schema(description = "ID del Curso", example = "1")
	private Long cursoId;
	@Schema(description = "ID del Categoria", example = "1")
	private Long categoriaId;
}
