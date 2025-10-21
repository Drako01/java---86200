package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	private List<Alumno> alumnos = new ArrayList<>();
	
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(Long id, String nombre, List<Alumno> alumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
