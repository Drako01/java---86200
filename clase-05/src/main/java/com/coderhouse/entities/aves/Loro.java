package com.coderhouse.entities.aves;

import com.coderhouse.entities.Mascota;

public class Loro extends Mascota{

	@Override
	public void hacerSolido() {
		System.out.println("El Loro " + getNombre() + " esta emitiendo Sonidos");
	}
	
	@Override
	public String toString() {
		return "Loro [Nombre=" + getNombre() + ", getColor()=" + getColor() + ", getTamanio()=" + getTamanio()
				+ ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso() + "]";
	}
	
}
