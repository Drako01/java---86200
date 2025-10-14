package com.coderhouse.sobrecarga;

public class Impresora {

	// Sobrecarga de METODOS
	
	public void imprimir(int numero) {
		System.out.println("Imprimiendo el numero: " + numero);
	}
	
	public void imprimir(String palabra) {
		System.out.println("Imprimiendo el String: " + palabra);
	}
	
	public void imprimir(String a, String b) {
		System.out.println("Imprimiendo los Strings: " + a + " y " + b);
	}

	public void imprimir(int i, String b) {
		System.out.println("Imprimiendo el numero: " + i + " y el String " + b);		
	}
	
	public void imprimir(int[] numeros) {
		System.out.println("Imprimiendo el Array de numeros");
		for(int n : numeros) {
			System.out.println("Numero " + n);
		}
	}
	
	public void imprimir(String[] palabras) {
		System.out.println("Imprimiendo el Array de Strings");
		for(String p : palabras) {
			System.out.println("String " + p);
		}
	}
}
