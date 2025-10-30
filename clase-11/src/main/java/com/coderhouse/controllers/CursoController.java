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

import com.coderhouse.models.Curso;
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
	public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
		try {
			Curso cursoCreado = svc.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado); // 201
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
}
