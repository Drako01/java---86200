package com.coderhouse.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InscripcionAlumnoDTO {

	private Long alumnoId;
	private List<Long> cursoIds;
}
