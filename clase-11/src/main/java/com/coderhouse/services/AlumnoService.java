package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CRUDInterface;
import com.coderhouse.models.Alumno;
import com.coderhouse.repositories.AlumnoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService implements CRUDInterface<Alumno, Long> {
	
	private final String message = "Alumno no encontrado";
	
	@Autowired
	private AlumnoRepository repo;

	@Override
	public List<Alumno> findAll() {
		return repo.findAll();
	}

	@Override
	public Alumno findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(message));
	}

	@Override
	public Alumno save(Alumno nuevoAlumno) {
		return repo.save(nuevoAlumno);
	}

	@Override
	@Transactional
	public Alumno update(Long id, Alumno alumnoActualizado) {
		Alumno alumno = findById(id);
		
		if(alumnoActualizado.getNombre() != null && !alumnoActualizado.getNombre().isEmpty()) {
			alumno.setNombre(alumnoActualizado.getNombre());
		}
		
		if(alumnoActualizado.getApellido() != null && !alumnoActualizado.getApellido().isEmpty()) {
			alumno.setApellido(alumnoActualizado.getApellido());
		}
		
		if(alumnoActualizado.getDni() != 0) {
			alumno.setDni(alumnoActualizado.getDni());
		}
		
		if(alumnoActualizado.getEdad() != 0) {
			alumno.setEdad(alumnoActualizado.getEdad());
		}
		
		if(alumnoActualizado.getLegajo() != null && !alumnoActualizado.getLegajo().isEmpty()) {
			alumno.setLegajo(alumnoActualizado.getLegajo());
		}
				
		return repo.save(alumno);
	}

	@Override
	public void deleteById(Long id) {
		if(!repo.existsById(id)) {
			throw new IllegalArgumentException(message);
		}
		repo.deleteById(id);
	}

}
