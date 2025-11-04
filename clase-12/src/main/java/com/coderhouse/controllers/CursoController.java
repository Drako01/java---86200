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

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoService svc;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAllCursos(){
		try {
			List<Curso> cursos = svc.findAll();
			return ResponseEntity.ok(cursos); // Code 200
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long cursoId) {
		try {		
			Curso curso = svc.findById(cursoId);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	@PostMapping("/create")
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
	
	@PutMapping("/{cursoId}")
	public ResponseEntity<Curso> updateCursoById(
			@PathVariable Long cursoId,@RequestBody Curso cursoActualizado){
		try {
			Curso curso = svc.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> deleteCursoById(@PathVariable Long cursoId){
		try {
			svc.deleteById(cursoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Error 404
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500		
		}
	}
	
	
	@PostMapping("/asignar-categoria")
	public ResponseEntity<?> asignarCategoriaACurso(@RequestBody AsignacionDeCategoriaACursoDTO dto){
		if(dto.getCursoId() == null || dto.getCategoriaId() == null) {
			return ResponseEntity.badRequest().body("El parametro ID no puede ser Null");
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
