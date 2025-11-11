package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CRUDInterface;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;
import com.coderhouse.repositories.CategoriaRepository;
import com.coderhouse.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoService implements CRUDInterface<Curso, Long> {

	private final String message = "Curso no encontrado";
	private final String messageCat = "Categoria no encontrado";
	@Autowired
	private CursoRepository repo;
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Override
	public List<Curso> findAll() {
		return repo.findAll();
	}

	@Override
	public Curso findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(message));
	}

	@Override
	@Transactional
	public Curso save(Curso cursoNuevo) {
		if(cursoNuevo.getNombre() != null && repo.existsByNombre(cursoNuevo.getNombre())) {
			throw new IllegalStateException("El curso con este Nombre ya existe");
		}
		return repo.save(cursoNuevo);
	}

	@Override
	@Transactional
	public Curso update(Long id, Curso cursoActualizado) {
		Curso curso = findById(id);
		
		if(cursoActualizado.getNombre() != null && !cursoActualizado.getNombre().isEmpty()) {
			curso.setNombre(cursoActualizado.getNombre());
		}
		
		return repo.save(curso);		
	}

	@Override
	public void deleteById(Long id) {
		if(!repo.existsById(id)) {
			throw new IllegalArgumentException(message);
		}
		repo.deleteById(id);
	}
	
	
	@Transactional
	public Curso asignarCategoriaAUnCurso(Long cursoId, Long categoriaId) {
		
		Curso curso = repo.findById(cursoId)
				.orElseThrow(() -> new IllegalArgumentException(message));
		
		Categoria categoria = repoCategoria.findById(categoriaId)
				.orElseThrow(() -> new IllegalArgumentException(messageCat));
		
		if(curso.getCategoria() != null && curso.getCategoria().getId().equals(categoriaId)) {
			throw new IllegalStateException("El curso ya tiene esta categoria asignada");
		}
		
		curso.setCategoria(categoria);
		
		return repo.save(curso);
	}

}
