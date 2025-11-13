package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Schema(description = "Modelo de Alumno")
@Table(name = "Alumnos")
public class Alumno {

	@Schema(description = "ID del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Schema(description = "Nombre del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alejandro")
	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Schema(description = "Apellido del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Di Stefano")
	@Column(name = "Apellido", nullable = false)
	private String apellido;

	@Schema(description = "DNI del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "22333555")
	@Column(name = "DNI", nullable = false, unique = true)
	private int dni;

	@Schema(description = "Legajo del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "L22333555")
	@Column(name = "Legajo", nullable = false, unique = true)
	private String legajo;

	@Schema(description = "Edad del Alumno", example = "18")
	@Column(name = "Edad")
	private int edad;

	@Schema(description = "Fecha de Alta del Alumno", example = "2025/11/11")
	private LocalDateTime createdAt;

	@Schema(description = "Lista de Cursos en los que se Inscribio el Alumno")
	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
	private List<Curso> cursos = new ArrayList<>();
}
