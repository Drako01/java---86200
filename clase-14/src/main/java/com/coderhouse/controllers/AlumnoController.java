package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.InscripcionAlumnoDTO;
import com.coderhouse.models.Alumno;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.AlumnoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/alumnos")
@Tag(name = "Gesti\u00f3n de Alumnos", description = "Endpoints para gestionar Alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@Operation(summary = "Obtener la lista de Todos los Alumnos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Alumnos obtenida correctamente", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Alumno.class)))}),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		try {
			List<Alumno> alumnos = alumnoService.findAll();
			return ResponseEntity.ok(alumnos); // Code 200
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@Operation(summary = "Obtener un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno encontrado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error al Obtener el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(
			@Parameter(description = "Identificador del alumno", example = "5", required = true)
			@PathVariable Long alumnoId) {
		try {
			Alumno alumno = alumnoService.findById(alumnoId);
			return ResponseEntity.ok(alumno); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@Operation(summary = "Crear un Alumno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Alumno creado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "409", description = "Error al intentar crear el Alumno - CONFLICT", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PostMapping("/create")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del alumno a crear",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Alumno inicial",
							value = "{\"nombre\":\"Laura\",\"apellido\":\"Garc\u00eda\",\"dni\":33444555,\"legajo\":\"L33444555\"}"
					),
					schema = @Schema(implementation = Alumno.class)
			)
	)
	public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno alumnoCreado = alumnoService.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); // 201
		} catch (IllegalStateException e) {
			ErrorResponse error = new ErrorResponse("Conflicto", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);	// 409	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@Operation(summary = "Actualizar un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno actualizado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PutMapping("/{alumnoId}")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del alumno a actualizar",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Actualizaci\u00f3n de alumno",
							value = "{\"nombre\":\"Ana\",\"apellido\":\"P\u00e9rez\",\"dni\":11222333}"
					),
					schema = @Schema(implementation = Alumno.class)
			)
	)
	public ResponseEntity<Alumno> updateAlumnoById(
			@Parameter(description = "Identificador del alumno", example = "5", required = true)
			@PathVariable Long alumnoId,
			@RequestBody Alumno alumnoActualizado) {
		try {
			Alumno alumno = alumnoService.update(alumnoId, alumnoActualizado);
			return ResponseEntity.ok(alumno); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@Operation(summary = "Eliminar un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Alumno eliminado correctamente", content = {
					@Content()}),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@DeleteMapping("/{alumnoId}")
	public ResponseEntity<Void> deleteAlumnoById(
			@Parameter(description = "Identificador del alumno", example = "5", required = true)
			@PathVariable Long alumnoId) {
		try {
			alumnoService.deleteById(alumnoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@Operation(summary = "Inscribir un Alumno a uno o varios Cursos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno inscripto correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "409", description = "Error al intentar inscribir al Alumno, hay un conflicto con los datos", 
				content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PostMapping("/inscribir")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Identificador del alumno y cursos a inscribir",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Inscripci\u00f3n m\u00faltiple",
							value = "{\"alumnoId\":5,\"cursoIds\":[1,2]}"
					),
					schema = @Schema(implementation = InscripcionAlumnoDTO.class)
			)
	)
	public ResponseEntity<?> inscribirAlumnoACursos(@RequestBody InscripcionAlumnoDTO dto) {
		try {
			Alumno alumno = alumnoService.inscribirAlumnoACursos(dto);
			return ResponseEntity.ok(alumno);
		} catch (IllegalStateException e) {
			ErrorResponse error = new ErrorResponse("Conflicto", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);	// 409
		} catch (IllegalArgumentException e) {
			ErrorResponse error = new ErrorResponse("Error 404", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);	// Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

}
