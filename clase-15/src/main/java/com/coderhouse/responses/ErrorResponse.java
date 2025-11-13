package com.coderhouse.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Modelo de Error personalizado")
public class ErrorResponse {
	@Schema(description = "Mensaje del Error", example = "Conflicto")
	private String message;
	
	@Schema(description = "Detalles del Error", example = "Alguno de los datos ingresados genera un conflicto")
	private String detail;
}
