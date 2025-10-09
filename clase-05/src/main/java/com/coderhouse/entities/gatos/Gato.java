package com.coderhouse.entities.gatos;

import com.coderhouse.entities.Mascota;

public class Gato extends Mascota {
	

	@Override
	public void hacerSolido() {
		System.out.println("El Gato " + getNombre() + " esta Maullando");
	}
	
	@Override
	public String toString() {
		return "Mi Gato se llama " + getNombre() + " y tiene "
				+ getEdad() + " años de Edad. Es de tamaño " + getTamanio() + ", y pesa " + getPeso()
				+ " Kg.";
	}
}
