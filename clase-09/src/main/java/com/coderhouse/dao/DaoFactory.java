package com.coderhouse.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Alumno;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;

import jakarta.persistence.EntityManager; // -> Hibernate
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory { // DAO -> Data Access Object
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persistirAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Transactional
	public void persistirCurso(Curso curso) {
		em.persist(curso);
	}
	
	@Transactional
	public void persistirCategoria(Categoria categoria) {
		em.persist(categoria);
	}
	
	@Transactional
	public Curso getCursoById(Long cursoId) throws Exception {
		try {
			TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id", Curso.class);
			return query.setParameter("id", cursoId).getSingleResult();
		} catch (Exception err) {
			throw new Exception("El curso no existe!");
		}
	}
	
	@Transactional
	public Categoria getCategoriaById(Long categoriaId) throws Exception {
		try {
			TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id", Categoria.class);
			return query.setParameter("id", categoriaId).getSingleResult();
		} catch (Exception err) {
			throw new Exception("La Categoria no existe!");
		}
	}

	@Transactional
	public Alumno getAlumnoById(Long alumnoId) throws Exception {
		try {
			TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.id = :id", Alumno.class);
			return query.setParameter("id", alumnoId).getSingleResult();
		} catch (Exception err) {
			throw new Exception("El Alumno no existe!");
		}
	}
	
	@Transactional
	public void asignarCategoriaACurso(Long cursoId, Long categoriaId) throws Exception{
		Curso curso = getCursoById(cursoId);
		if(curso == null) {
			throw new Exception("El curso con ID: " + cursoId + " no existe.!");
		}
				
		Categoria categoria = getCategoriaById(categoriaId);
		if(categoria == null) {
			throw new Exception("La categoria con ID: " + categoriaId + " no existe.!");
		}
		
		curso.setCategoria(categoria);
		
		// Persistir los datos en la BD
		em.merge(curso);
	}
	
	@Transactional
	public void inscribirAUnAlumnoAUnoOVariosCursos(
			Long alumnoId, List<Long> cursosIds) throws Exception {
		
		Alumno alumno = getAlumnoById(alumnoId);
		if(alumno == null) {
			throw new Exception("El alumno con ID: " + alumnoId + " no existe.!");
		}
		
		for(Long cursoId : cursosIds) {			
			Curso curso = getCursoById(cursoId);
			if(curso == null) {
				throw new Exception("El curso con ID: " + cursoId + " no existe.!");
			}
			
			// Asociar al Alumno con el Curso
			if(!curso.getAlumnos().contains(alumno)) {
				curso.getAlumnos().add(alumno);
			}
			
			// Opcional: Asociar el Curso al Alumno
			if(!alumno.getCursos().contains(curso)) {
				alumno.getCursos().add(curso);
			}
			
			em.merge(curso);
		}
		
		em.merge(alumno);
		em.flush();		
	}
}
