package com.coderhouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;

@SpringBootApplication
public class Clase09Application implements CommandLineRunner{
	
	@Autowired // Inyecta dependencias 
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(Clase09Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			Categoria cat1 = new Categoria("Programacion Frontend");
			Categoria cat2 = new Categoria("Programacion Backend");
			Categoria cat3 = new Categoria("Data Science");
			Categoria cat4 = new Categoria("Habilidades Blandas");
			
			Curso curso1 = new Curso("Java"); // Programacion Backend
			Curso curso2 = new Curso("JavaScript"); // Programacion Frontend
			Curso curso3 = new Curso("React");  // Programacion Frontend
			Curso curso4 = new Curso("Angular"); // Programacion Frontend
			Curso curso5 = new Curso("SQL"); // Data Science
			Curso curso6 = new Curso("MongoDB"); // Data Science
			Curso curso7 = new Curso("NodeJS"); // Programacion Backend
			Curso curso8 = new Curso("PHP"); // Programacion Backend
			Curso curso9 = new Curso("Desarrollo Web");
			Curso curso10 = new Curso("Scrum");
			
						
			Alumno alumno1 = new Alumno("Alejandro", "Di Stefano", 22333666, "L22333666", 49);
			Alumno alumno2 = new Alumno("Jhonatan", "Recoba", 33666555, "L33666555", 49);
			Alumno alumno3 = new Alumno("Lautaro", "Braile", 11666888, "L11666888", 49);
			Alumno alumno4 = new Alumno("Aaron", "Serrano", 88999555, "L88999555", 49);
			Alumno alumno5 = new Alumno("Ignacio", "Baquero", 77555222, "L77555222", 49);
			
			dao.persistirCategoria(cat1); // 1
			dao.persistirCategoria(cat2); // 2
			dao.persistirCategoria(cat3); // 3
			dao.persistirCategoria(cat4); // 4

			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);
			dao.persistirCurso(curso5);
			dao.persistirCurso(curso6);
			dao.persistirCurso(curso7);
			dao.persistirCurso(curso8);
			dao.persistirCurso(curso9);
			dao.persistirCurso(curso10);
			
			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);
			dao.persistirAlumno(alumno5);
			
			dao.asignarCategoriaACurso(curso1.getId(), cat2.getId());
			dao.asignarCategoriaACurso(curso2.getId(), cat1.getId());
			dao.asignarCategoriaACurso(curso3.getId(), cat1.getId());
			dao.asignarCategoriaACurso(curso4.getId(), cat1.getId());
			dao.asignarCategoriaACurso(curso5.getId(), cat3.getId());
			dao.asignarCategoriaACurso(curso6.getId(), cat3.getId());
			dao.asignarCategoriaACurso(curso7.getId(), cat2.getId());
			dao.asignarCategoriaACurso(curso8.getId(), cat2.getId());
			dao.asignarCategoriaACurso(curso9.getId(), cat1.getId());
			dao.asignarCategoriaACurso(curso10.getId(), cat4.getId());
			
			List<Long> javaCarrerasIntensiva = new ArrayList<>();
			if(curso9 != null) javaCarrerasIntensiva.add(curso9.getId());
			if(curso10 != null) javaCarrerasIntensiva.add(curso10.getId());
			if(curso2 != null) javaCarrerasIntensiva.add(curso2.getId());
			if(curso3 != null) javaCarrerasIntensiva.add(curso3.getId());
			if(curso4 != null) javaCarrerasIntensiva.add(curso4.getId());
			if(curso1 != null) javaCarrerasIntensiva.add(curso1.getId());
			
			List<Long> desarrolloWeb = new ArrayList<>();
			if(curso9 != null) desarrolloWeb.add(curso9.getId());
			if(curso2 != null) desarrolloWeb.add(curso2.getId());
			if(curso6 != null) desarrolloWeb.add(curso6.getId());
			if(curso3 != null) desarrolloWeb.add(curso3.getId());
			
			List<Long> java = new ArrayList<>();
			if(curso1 != null) java.add(curso1.getId());
			
			
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno1.getId(), desarrolloWeb);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno2.getId(), desarrolloWeb);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno3.getId(), desarrolloWeb);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno4.getId(), desarrolloWeb);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno5.getId(), javaCarrerasIntensiva);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno2.getId(), javaCarrerasIntensiva);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno3.getId(), javaCarrerasIntensiva);
			dao.inscribirAUnAlumnoAUnoOVariosCursos(alumno1.getId(), java);
				
					
		} catch(Exception err) {
			err.getMessage();
		}
		
	}


}
