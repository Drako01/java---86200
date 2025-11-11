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

import com.coderhouse.models.Categoria;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Gestión de Categorias", description = "Endpoints para gestionar Categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService svc;
	
	@Operation(summary = "Obtener la lista de Todas las Categorias")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Categorias obtenida correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))}),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		try {
			List<Categoria> categorias = svc.findAll();
			return ResponseEntity.ok(categorias); // Code 200
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@Operation(summary = "Obtener una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Categoria encontrado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))}),
			@ApiResponse(responseCode = "404", description = "Error al Obtener la Categoria", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long categoriaId){
		try {
			Categoria categoria = svc.findById(categoriaId);
			return ResponseEntity.ok(categoria); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@Operation(summary = "Crear una Categoria")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Categoria creada correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))}),
			@ApiResponse(responseCode = "409", description = "Error al intentar crear la Categoria - CONFLICT", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PostMapping("/create")
	public ResponseEntity<?> createCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria categoriaCreada = svc.save(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada); // 201
		} catch (IllegalStateException e) {
			ErrorResponse error = new ErrorResponse("Conflicto", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);	// 409
		}catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	
	@Operation(summary = "Actualizar una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Categoria actualizada correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))}),
			@ApiResponse(responseCode = "404", description = "Error al obtener la Categoria", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@PutMapping("/{categoriaId}")
	public ResponseEntity<Categoria> updateCategoriaById(
			@PathVariable Long categoriaId, @RequestBody Categoria categoriaActualizada){
		try {
			Categoria categoria = svc.update(categoriaId, categoriaActualizada);
			return ResponseEntity.ok(categoria); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@Operation(summary = "Eliminar una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Categoria eliminada correctamente", content = {
					@Content()}),
			@ApiResponse(responseCode = "404", description = "Error al obtener la Categoria", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
		})
	@DeleteMapping("/{categoriaId}")
	public ResponseEntity<Void> deleteCategoriaById(@PathVariable Long categoriaId){
		try {
			svc.deleteById(categoriaId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
}
