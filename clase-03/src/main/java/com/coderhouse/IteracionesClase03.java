package com.coderhouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteracionesClase03 {

	public static void main(String[] args) {
		// Definimos nuestro primer array
		/*
		int[] numerosEnteros = new int[5]; // Defino un Array de enteros de 5 elementos
		
		numerosEnteros[0] = 5;
		numerosEnteros[1] = -5;
		numerosEnteros[2] = 2;
		numerosEnteros[3] = -12;
		numerosEnteros[4] = 0;
		//numerosEnteros[5] = 9;
		System.out.println("El elemento en la Posicion 4 (original) es: " + numerosEnteros[4]);
		System.out.println("Posicion en memoria: "+numerosEnteros); // Imprimir la posicion en memoria
		
		System.out.println("El elemento en la Posicion 0 es: " + numerosEnteros[0]);
		System.out.println("El elemento en la Posicion 1 es: " + numerosEnteros[1]);
		System.out.println("El elemento en la Posicion 2 es: " + numerosEnteros[2]);
		System.out.println("El elemento en la Posicion 3 es: " + numerosEnteros[3]);
		numerosEnteros[4] = 10;
		System.out.println("El elemento en la Posicion 4 es: " + numerosEnteros[4]);
		*/
		/*
		String[] palabras = new String[5];
		
		System.out.println("El elemento en la Posicion 3 es: " + palabras[3]); // Imprime null si no se el asigna valor
		*/
		/*
		String[] palabras = {
					"Hola",
					"Mundo",
					"CoderHouse",
					"Argentina",
					"Alejandro",
					"Otro String"
				};
		
		int[] numeros = {1,2,3};
		
		System.out.println("El array palabras contiene " + palabras.length + " elementos");
		System.out.println("El Array palabras " + Arrays.toString(palabras));
		System.out.println("El Array numeros " + Arrays.toString(numeros));
		
		*/
		
		// Listas
		
		List<String> palabras = new ArrayList<>();
		
		List<String> palabras2 = new ArrayList<>();
		
		palabras.add("Hola"); //0
		palabras.add("Mundo"); //1
		palabras.add("CoderHouse"); //2
		palabras.add("Java"); //3
		palabras.add("JavaScript"); //4
		
		palabras2.add("Palabra"); // 0????
		palabras2.addAll(palabras);
		palabras2.add("Elemento");
		
		//palabras.removeAll(palabras2); // Elimina los elementos que son similares a ambos
		//palabras.clear(); // Vacia por completo la Lista
		//palabras2.clear();
		/*
		System.out.println("La Lista palabras es " + palabras);
		System.out.println("La Lista palabras es " + palabras2);
		System.out.println(palabras2.containsAll(palabras)); // Devuelve un Boolean -> true
		System.out.println(palabras.containsAll(palabras2)); // Devuelve un Boolean -> false
		System.out.println(palabras.isEmpty()); // Esta vacia??? -> false
		//palabras.clear();
		System.out.println(palabras.isEmpty()); // Esta vacia??? -> true
		*/
		/*
		//palabras.clear();
		if(palabras.isEmpty()) {
			System.out.println("La Lista palabras esta Vacia");
		} else {
			System.out.println("La Lista palabras es " + palabras);
			System.out.println("La cantidad de elementos de la Lista palabras es " + palabras.size() + " elementos");
			System.out.println(palabras.get(0));
			for (String palabra : palabras) { // Extraiga cada elemento de la Lista
				int indice = palabras.indexOf(palabra); // Extraigo el indice de cada elemento de la lista
				
				System.out.println("La Palabra con indice " + indice + " es: " + palabra);				
			}
			
			for (int i = 0; i < palabras.size(); i++) {
				System.out.println("La Palabra con indice (Usando for convencional) " + i + " es: " + palabras.get(i));	
			}
			
			Iterator<String> iterator = palabras.iterator();
			
			while(iterator.hasNext()) {
				String palabra = iterator.next();
				System.out.println("Palabra (Usando Iterator) " + palabra);
				iterator.remove(); // Importante remover el elmento consultado para evitar un ciclo infinito
			}
			
		}
		*/
		/*
		int indice = palabras.indexOf("CoderHouse");
		
		System.out.println("El indice de la palabra CoderHouse es: " + indice);
		
		*/
		
		// while y do while
		/*
		int indice = 0;
		
		while(!palabras.isEmpty() && indice < palabras.size()) {
			System.out.println("Palabra: (usando while) " + palabras.get(indice));
			indice++;
		}
		
		System.out.println("===============================");
		
		indice = 0; // Reinicializamos la variable en 0
		
		if(!palabras.isEmpty()) {
			do {
				System.out.println("Palabra: (usando do while) " + palabras.get(indice));
				indice++;
			} while(indice < palabras.size());
		} else {
			System.err.println("La Lista esta vacia");
		}
		*/
		/*
		// Uso de Foreach
		palabras.forEach( palabra -> {
			System.out.println("Palabra (usando foreach): " + palabra);
		});
		*/
		// Otros metodos de manipulacion de Listas
		palabras.add("Nueva");
		palabras.add("Nueva2");
		palabras.remove("Nueva");
		
		palabras.set(5, "Nuevo String"); // Sirve para reemplazar un elemento segun su indice
		
		System.out.println("La Lista palabras "+palabras);
		
		
	}

}
