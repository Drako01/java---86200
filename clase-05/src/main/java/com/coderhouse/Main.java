package com.coderhouse;

import com.coderhouse.entities.aves.Loro;
import com.coderhouse.entities.gatos.Gato;
import com.coderhouse.entities.perros.Perro;
import com.coderhouse.excepciones.EdadMascotaException;

public class Main {

	public static void main(String[] args) throws EdadMascotaException {
		try {
		//Mascota mascota = new Mascota();
			Perro perrito = new Perro("Firulay", 3);
			perrito.setRaza("Golden");
			perrito.setTamanio("Grande");
			perrito.setColor("Dorado");
			perrito.setPeso(25.8f);
			System.out.println(perrito);
	
			
			Perro miPerro = new Perro("Daisy", "Beige", "Chico", 4, 3.5f);
			miPerro.setRaza("Yorky");
			System.out.println(miPerro);
			
			Gato gatito = new Gato();
			gatito.setNombre("Michi");
			gatito.setColor("Blanco");
			gatito.setEdad(5);
			gatito.setPeso(2.5f);
			gatito.setTamanio("Chico");
			
			System.out.println(gatito);
			
			Loro lorito = new Loro();
			lorito.setNombre("Anastasio");
			lorito.setColor("Verde");
			lorito.setEdad(25);
			lorito.setPeso(0.5f);
			lorito.setTamanio("Chico");
			
			System.out.println(lorito);
		} catch (EdadMascotaException e) {
			System.err.println(e);
		} finally {
			System.out.println("Finalizo la Aplicacion...");
		}
		
	}

}
