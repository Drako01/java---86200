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

import com.coderhouse.dto.AsignacionDeCategoriaACursoDTO;
import com.coderhouse.models.Curso;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.CursoService;

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
@RequestMapping("/api/cursos")
@Tag(name = "Gestion de Cursos", description = "Endpoints para gestionar Cursos")
public class CursoController {

	@Autowired
	private CursoService svc;
	
	@Operation(summary = "Obtener la lista de Todos los Cursos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Cursos obtenida correctamente", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Curso.class)))}),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping
	public ResponseEntity<List<Curso>> getAllCursos(){
		try {
			List<Curso> cursos = svc.findAll();
			return ResponseEntity.ok(cursos); // Code 200
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@Operation(summary = "Obtener un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curso encontrado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))}),
			@ApiResponse(responseCode = "404", description = "Error al Obtener el Curso", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(
			@Parameter(description = "Identificador del curso", example = "1", required = true)
			@PathVariable Long cursoId) {
		try {		
			Curso curso = svc.findById(cursoId);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	@Operation(summary = "Crear un Curso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Curso creado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))}),
			@ApiResponse(responseCode = "409", description = "Error al intentar crear el Curso - CONFLICT", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PostMapping("/create")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del curso a crear",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Curso Backend",
							value = "{\"nombre\":\"Java Backend\"}"
					),
					schema = @Schema(implementation = Curso.class)
			)
	)
	public ResponseEntity<?> createCurso(@RequestBody Curso curso) {
		try {
			Curso cursoCreado = svc.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado); // 201
		} catch (IllegalStateException e) {
			ErrorResponse error = new ErrorResponse("Conflicto", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);	// 409	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	@Operation(summary = "Actualizar un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curso actualizado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))}),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Curso", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PutMapping("/{cursoId}")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del curso a actualizar",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Actualizacion de Curso",
							value = "{\"nombre\":\"Java Avanzado\"}"
					),
					schema = @Schema(implementation = Curso.class)
			)
	)
	public ResponseEntity<Curso> updateCursoById(
			@Parameter(description = "Identificador del curso", example = "1", required = true)
			@PathVariable Long cursoId,
			@RequestBody Curso cursoActualizado){
		try {
			Curso curso = svc.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	@Operation(summary = "Eliminar un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Curso eliminado correctamente", content = {
					@Content()}),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Curso", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> deleteCursoById(
			@Parameter(description = "Identificador del curso", example = "1", required = true)
			@PathVariable Long cursoId){
		try {
			svc.deleteById(cursoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	
	@Operation(summary = "Asignar una Categoria a un Curso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curso asociado correctamente a la Categoria", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))}),
			@ApiResponse(responseCode = "400", description = "Par\u00e1metros incompletos", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Error al obtener el Curso o Categoria", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "409", description = "Error al intentar asociar al Curso, hay un conflicto con los datos", 
				content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PostMapping("/asignar-categoria")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Identificadores necesarios para relacionar un curso con una categoria",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(value = "{\"cursoId\":1,\"categoriaId\":2}"),
					schema = @Schema(implementation = AsignacionDeCategoriaACursoDTO.class)
			)
	)
	public ResponseEntity<?> asignarCategoriaACurso(@RequestBody AsignacionDeCategoriaACursoDTO dto){
		if(dto.getCursoId() == null || dto.getCategoriaId() == null) {
			ErrorResponse error = new ErrorResponse("Solicitud invalida", "El parametro ID no puede ser null");
			return ResponseEntity.badRequest().body(error);
		}		
		try {
			Curso cursoActualizado = svc.asignarCategoriaAUnCurso(
					dto.getCursoId(),
					dto.getCategoriaId()
				);
			return ResponseEntity.ok(cursoActualizado); // 200
		} catch (IllegalArgumentException e) {
			ErrorResponse error = new ErrorResponse("Error 404", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);	// Error 404
		} catch (IllegalStateException e) {
			ErrorResponse error = new ErrorResponse("Conflicto", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);	// 409			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
}
