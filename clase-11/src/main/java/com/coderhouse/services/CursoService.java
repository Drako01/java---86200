package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CRUDInterface;
import com.coderhouse.models.Curso;
import com.coderhouse.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoService implements CRUDInterface<Curso, Long> {

	private final String message = "Curso no encontrado";
	@Autowired
	private CursoRepository repo;
	
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
	public Curso save(Curso cursoNuevo) {
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

}
