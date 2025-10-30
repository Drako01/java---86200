package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CRUDInterface;
import com.coderhouse.models.Categoria;
import com.coderhouse.repositories.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService implements CRUDInterface<Categoria, Long> {

	private final String message = "Categoria no encontrada";
	
	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public List<Categoria> findAll() {
		return repo.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(message));
	}

	@Override
	public Categoria save(Categoria categoriaNueva) {
		return repo.save(categoriaNueva);
	}

	@Override
	@Transactional
	public Categoria update(Long id, Categoria categoriaActualizada) {
		Categoria categoria = findById(id);
		
		if(categoriaActualizada.getNombre() != null && !categoriaActualizada.getNombre().isEmpty()) {
			categoria.setNombre(categoriaActualizada.getNombre());
		}
		return repo.save(categoria);
	}

	@Override
	public void deleteById(Long id) {
		if(!repo.existsById(id)) {
			throw new IllegalArgumentException(message);
		}
		repo.deleteById(id);		
	}

}
