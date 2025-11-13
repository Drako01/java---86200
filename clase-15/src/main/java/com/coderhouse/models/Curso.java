package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Schema(description = "Modelo de Curso")
@Table(name = "Cursos")
public class Curso {

	@Schema(description = "ID del Curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Schema(description = "Nombre del Curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java")
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Schema(description = "Lista de Alumnos que tienen asignado este Curso")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "curso_alumno", 
		joinColumns = @JoinColumn(name = "curso_id"), 
		inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	@JsonIgnore
	private List<Alumno> alumnos = new ArrayList<>();
	
	@Schema(description = "Categoria del Curso")
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;

}
