package com.coderhouse.entities.perros;

import com.coderhouse.entities.Mascota;
import com.coderhouse.excepciones.EdadMascotaException;

public class Perro extends Mascota {

	private String raza;
	
	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, String color, String tamanio, int edad, float peso) throws EdadMascotaException {
		super(nombre, color, tamanio, edad, peso);
		// TODO Auto-generated constructor stub
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
	// Decorador -> Reescribe el metodo -> Polimorfismo
	@Override
	public String toString() {
		return "Mi Perro es de raza " + getRaza() + ", se llama " + getNombre() + " y tiene "
				+ getEdad() + " años de Edad. Es de tamaño " + getTamanio() + ", y pesa " + getPeso()
				+ " Kg.";
	}
	
	
	
}
