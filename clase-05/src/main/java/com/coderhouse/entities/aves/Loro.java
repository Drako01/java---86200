package com.coderhouse.entities.aves;

import com.coderhouse.entities.Mascota;

public class Loro extends Mascota{

	@Override
	public String toString() {
		return "Loro [Nombre=" + getNombre() + ", getColor()=" + getColor() + ", getTamanio()=" + getTamanio()
				+ ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso() + "]";
	}
	
}
