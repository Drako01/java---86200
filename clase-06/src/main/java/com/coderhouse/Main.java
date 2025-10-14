package com.coderhouse;

import com.coderhouse.abstractas.Vehiculo;
import com.coderhouse.ejercicios.Suma;
import com.coderhouse.entities.Moto;
import com.coderhouse.entities.caninos.Perro;
import com.coderhouse.sobrecarga.Impresora;

public class Main {

	public static void main(String[] args) {

		/*
		Perro perrito = new Perro("Firulay", 5);

		//System.out.println(perrito);
		
		
		
		perrito.caminar();
		perrito.comer();
		perrito.ladrar();
		perrito.moverLaCola();
		perrito.olfatear();
		perrito.setEstaVivo(true);
		
		perrito.setEstaVivo(true);
		Perro perrito2 = new Perro();
		
		perrito2.setNombre("Daisy");
		perrito2.setEdad(4);
		perrito2.setEstaVivo(true);
		
		System.out.println(perrito2);
		perrito2.caminar();
		perrito2.comer();
		perrito2.ladrar();
		perrito2.moverLaCola();
		perrito2.olfatear();
		perrito2.respirar();
		
		perrito.respirar();
		perrito2.respirar();
		
		System.out.println(perrito.estaVivo());
		System.out.println(perrito2.estaVivo());
		*/
		/*
		Suma suma = new Suma(155, 256);
		suma.enviarMensaje();
		suma.enviarResultado();
		
		Suma suma2 = new Suma();
		suma2.setA(20);
		suma2.setB(65);
		suma2.enviarMensaje();
		suma2.enviarResultado();
		*/
		/*
		Moto moto = new Moto();
		
		moto.setMarca("Harley");
		moto.setColor("Negra");
		moto.setModelo("1990");
		moto.setRuedas(2);
		
		System.out.println(moto);
		moto.mostrarCantidadDeRuedas();
		
		Moto moto2 = new Moto();
		*/
		
		Impresora imp = new Impresora();
		
		imp.imprimir(22);
		
		imp.imprimir("Palabra");
		imp.imprimir("Esto es un String");
		
		imp.imprimir("Palabra", "Palabra2");
		imp.imprimir(10, "Palabra");
		int[] numeros = {1,2,3,6,5,88,91,-4,-11,9};
		
		imp.imprimir(numeros);
		
		String[] palabras = {"Hola", "Mundo", "Coders"};
		
		imp.imprimir(palabras);
		
	}

}
