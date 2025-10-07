package com.coderhouse;

import com.coderhouse.objetos.animados.Gato;
import com.coderhouse.objetos.animados.Perro;

// La Clase Principal del Proyecto
public class ObjetosClase04 {

	public static void main(String[] args) throws Exception{
		/*
		//Creamos nuestro primer Perro
		Perro primerPerro = new Perro();

		primerPerro.nombre = "Firulay";
		primerPerro.color = "Blanco";
		primerPerro.edad = 3;
		primerPerro.peso = 4.5f;
		primerPerro.raza = "Yorky";
		primerPerro.tamanio = "Madiano";
		
		System.out.println(primerPerro.nombre);
		System.out.println(primerPerro.color);
		System.out.println(primerPerro.edad);
		System.out.println(primerPerro.peso);
		System.out.println(primerPerro.raza);
		System.out.println(primerPerro.tamanio);

		primerPerro.saltar();
		primerPerro.caminar();
		primerPerro.comer();
		primerPerro.ladrar();
		*/
		/*
		Perro segundoPerro = new Perro();
		segundoPerro.setNombre("Firulay");
		segundoPerro.setColor("Blanco");
		segundoPerro.setEdad(3);
		segundoPerro.setPeso(4.5f);
		segundoPerro.setRaza("Yorky");
		segundoPerro.setTamanio("Mediano");
		segundoPerro.saltar();
		segundoPerro.caminar();
		segundoPerro.comer();
		segundoPerro.mostrarAtributos();
		//segundoPerro.ladrar();
		Perro.ladrar();
		
		Perro tercerPerro = new Perro();
		tercerPerro.setNombre("Daisy");
		tercerPerro.setColor("Beige");
		tercerPerro.setEdad(12);
		tercerPerro.setPeso(3.5f);
		tercerPerro.setRaza("Yorky");
		tercerPerro.setTamanio("Chico");
		tercerPerro.saltar();
		tercerPerro.caminar();
		tercerPerro.comer();
		tercerPerro.mostrarAtributos();
		//tercerPerro.ladrar(); // Cuando no era estatico
		
		// Invocamos metodo estaticos
		Perro.ladrar();
		Math.random();
		
		//System.out.println(segundoPerro);
		//System.out.println(tercerPerro);
		*/
		/*
		double radio = 27.5;
		System.out.println("El área de un Círculo de radio " + radio +
				" cm. es de " + calcularAreaDelCirculo(radio) + " cm.2");
		
		//--------------------------------------------------------------
		
		String[] nombres = new String[] {
			"Lautaro",
			"Nicolas",
			"Jonathan",
			"Pepito",
			"Alejandro",
			nombre
		};
		imprimirListaDeNombres(nombres);
		*/
		
		Gato primerGato = new Gato();
		
		primerGato.setNombre("Michifus");
		primerGato.setEdad(5);
		primerGato.setTamanio("Mediano");
		primerGato.comer();
		
		Gato.mauyar();
		
		
	}
	
	public static double calcularAreaDelCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);		
	}
	
	private static void imprimirListaDeNombres(String[] nombrePersonas) {
		for(String nombre: nombrePersonas) {
			System.out.println("Nombre: " + nombre);
		}
	}
	
	static final double PI;
	static final double DOUBLE_PI;
	
	static {
		PI = 3.14152653889;
		DOUBLE_PI = 6.28;
	}
	
	static String nombre = "Alejandro 2";
	
	
}
