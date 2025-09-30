package com.coderhouse;

//import java.util.Scanner;

public class Clase02 {

	public static void main(String[] args) {
		/*
		int numeroA = -2; int numeroB = 2;
		
		System.out.println("Empezando programa...");
		//if(esto es true) {ejecutas esto};
		if(numeroA > numeroB) {
			System.out.println("El numero A es Mayor que el numero B");			
		} else if(numeroA < numeroB){
			System.out.println("El numero A es Menor que el numero B");
		} else {
			System.out.println("Ambos numeros son iguales");
		}

		System.out.println("Terminando programa...");
		*/
		
		// Calculadora
		/*
		float numeroA = 10; float numeroB = 0;
		
		float resultado = numeroA / numeroB;
		
		
		if(numeroB != 0) {
				System.out.println("El resultado es: "+resultado);
		} else {
			System.err.println("Error, No se puede Dividir por Cero");
		}
		*/
		/*
		if(numeroB == 0) {System.err.println("Error, No se puede Dividir por Cero");}
		System.out.println("El resultado es: "+resultado);
		*/
		
		// Ingresar datos por Consola
		//Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("Ingrese un número (Que sea en un Formato Numerico y Entero)");
		
		int numeroIngresado = scanner.nextInt();
		
		if(numeroIngresado > 0) {
			System.out.println("El numero " + numeroIngresado + " es un numero Positivo.!");
		} else if (numeroIngresado < 0){
			System.out.println("El numero " + numeroIngresado + " es un numero Negativo.!");
		} else if (numeroIngresado == 0){
			System.out.println("El numero " + numeroIngresado + " es Cero");
		} else {
			System.err.println("Usted ingreso un dato no valido.!");
		}
		System.out.println("Terminando programa...");
		*/
		/*
		System.out.println("Ingrese un numero para obtener el dia de la semana");
		int numeroIngresado = scanner.nextInt();
		
		if(numeroIngresado == 1) {
			System.out.println("Hoy es Lunes");
		} else if(numeroIngresado == 2) {
			System.out.println("Hoy es Martes");
		}else if(numeroIngresado == 3) {
			System.out.println("Hoy es Miercoles");
		}else if(numeroIngresado == 4) {
			System.out.println("Hoy es Jueves");
		}else if(numeroIngresado == 5) {
			System.out.println("Hoy es Viernes");
		}else if(numeroIngresado == 6) {
			System.out.println("Hoy es Sabado");
		}else if(numeroIngresado == 7) {
			System.out.println("Hoy es Domingo");
		} else {
			System.err.println("Error, el dia ingresado es incorrecto");
		}
		*/
		
		
		/*
		System.out.println("Ingrese un numero para obtener el dia de la semana");
		int ingreseUnDiaDeLaSemana = scanner.nextInt();
		String nombreDeLaSemana = null;
		*/
		/*
		switch(ingreseUnDiaDeLaSemana) {
			case 1: 
				System.out.println("Hoy es Lunes");
				break;
			case 2: 
				System.out.println("Hoy es Martes");
				break;
			case 3: 
				System.out.println("Hoy es Miercoles");
				break;
			case 4: 
				System.out.println("Hoy es Jueves");
				break;
			case 5: 
				System.out.println("Hoy es Viernes");
				break;
			case 6: 
				System.out.println("Hoy es Sabado");
				break;
			case 7: 
				System.out.println("Hoy es Domingo");
				break;
			default:
				System.err.println("Error, el dia ingresado es incorrecto");
		}*/
		/*
		switch(ingreseUnDiaDeLaSemana) {
			case 1: 
				nombreDeLaSemana = "Lunes";
				break;
			case 2: 
				nombreDeLaSemana = "Martes";
				break;
			case 3: 
				nombreDeLaSemana = "Miercoles";
				break;
			case 4: 
				nombreDeLaSemana = "Jueves";
				break;
			case 5: 
				nombreDeLaSemana = "Viernes";
				break;
			case 6: 
				nombreDeLaSemana = "Sabado";
				break;
			case 7: 
				nombreDeLaSemana = "Domingo";
				break;
			default:
				System.err.println("Error, el dia ingresado es incorrecto");
		}
		
		if(ingreseUnDiaDeLaSemana > 0 && ingreseUnDiaDeLaSemana < 8) {			
			System.out.println("Hoy es " + nombreDeLaSemana);
		}
		*/
		/*
		
		System.out.println("Ingrese el dia de la semana (con Palabras)");
		
		String diaIngresado = scanner.nextLine().trim().toLowerCase();
		
		switch(diaIngresado) {
			case "lunes", "martes", "miercoles", "miércoles", "jueves", "viernes":
				System.out.println("Es dia laborable... Anda a Luburar Vago.!!");
				break;
			case "sabado", "sábado", "domingo":
				System.out.println("Hoy descansas...");
				break;
			default: 
				System.err.println("Error, El dia ingresado es incorrecto.!");
		}
		
		scanner.close();
		*/
		
		// Operadores Ternarios
		/*
		int numeroA = 12;
		int numeroB = 12;
		
		boolean condicion = numeroA > numeroB;
		
		String mensaje = condicion
				? "El numero " + numeroA + " es mayor que " + numeroB
				: "El numero " + numeroA + " es menor o igual que " + numeroB;
		
		System.out.println(mensaje);
		*/
		
		// Datos Random
		/*
		float randomNumber = 0;		
		
		randomNumber = (float) Math.random(); // Casteamos a float para ahorrar memoria
		System.out.println(randomNumber);
		
		*/
		// Supongamos que necesito generar numeros aleatoreos desde 1 a 100 (con la posibilidad de 
		// cambiar dinamicamente los valores max y min)
		
		/*
		int min = 1;
		int max = 100;
		
		int random = (int) (Math.random() * (max - min + 1) + min);
		
		System.out.println(random);
		*/
		
		final double PI = Math.PI;
		
		System.out.println(PI);
	}

}
