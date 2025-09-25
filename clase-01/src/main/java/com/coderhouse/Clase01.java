package com.coderhouse;

public class Clase01 {

	public static void main(String[] args) {
		
		// Tipo  Nombre
		String entrada = "Hola Coders como estan?...";
		// System.out.println(entrada);
		// System.out.println("---------------");
		// System.out.println(entrada);
		
		int miPrimerNumeroEntero = 2025;
		// System.out.println(miPrimerNumeroEntero);
		
		float numeroDecimal = 10.501f;
		// System.out.println(numeroDecimal);
		
		String mes = "Septiembre";
		int anio = 2025;
		int dia = 25;
		
		// System.out.println("Hoy es " + dia + " de " + mes + " del año " + anio);
		
		// Declarar variable
		String indefinida;
		
		// Asignamos un valor a la Varaible
		indefinida = "Definida";
		indefinida = "Definida 1";
		indefinida = "Definida 2";
		
		// System.out.println(indefinida);
		
		// Operaciones aritmeticas
		int suma = 1 + 2;
		// System.out.println(suma);
		int suma1 = 12 + 25;
		// System.out.println(suma1);
		
		// System.out.println(suma + suma1);
		
		// System.out.println(suma + indefinida); // Se concatenan
		
		final int NUMERO_A = 10;		
		// NUMERO_A = 565656; -> No se puede reasignar una Constante.
		final int NUMERO_B = 25;
		
		// System.out.println(NUMERO_A + NUMERO_B);
		
		byte numeroChico = (byte) 128;
		int anioActual = 2025;
		
		//byte numeroA = 12;
		//byte numeroB = 2;
		
		// System.out.println(numeroA / numeroB);
		
		int contador = 0;
		contador = contador + 1;
		contador = contador + 1;
		contador = contador + 1;
		contador++;
		contador++; // Siempre suma 1
		// System.out.println(contador);
		
		// Todas estas operaciones devuelven un Boolean
		byte numeroA = 12;
		byte numeroB = 2;
		byte numeroC = 2;
		char numeroD = '2';
		
		String numeroE = "2";
		
		System.out.println(numeroA == numeroA); // true
		System.out.println(numeroA == numeroB); // false
		System.out.println(numeroA != numeroB); // true
		System.out.println(numeroA != numeroC); // true
		System.out.println(numeroB != numeroC); // false
		
		System.out.println(numeroB < numeroC); // numeroB es menor que numeroC ??? -> false
		System.out.println(numeroA < numeroC); // numeroB es menor que numeroC ??? -> false
		System.out.println(numeroB < numeroA); // numeroB es menor que numeroC ??? -> true
		
		System.out.println(numeroB > numeroC); // numeroB es mayor que numeroC ??? -> false
		System.out.println(numeroA > numeroC); // numeroB es mayor que numeroC ??? -> true
		System.out.println(numeroB > numeroA); // numeroB es mayor que numeroC ??? -> false
		
		System.out.println(numeroB >= numeroC); // numeroB es mayor o igual que numeroC ??? -> true
		
		System.out.println(numeroB <= numeroC); // numeroB es menor o igual que numeroC ??? -> true
		
		// Comparacion entre un byte y un char
		// System.out.println(numeroB == numeroE);
				
	}

}
