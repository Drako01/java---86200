package com.coderhouse.objetos.animados;

public class Perro {

	// Constante o Variable de Clase
	private static final int EDAD_MAXIMA = 15;
	
	String messageError = "El Perro no vive mas de " + EDAD_MAXIMA + " años de edad";
	
	// Atributos del Objeto o Variables de Instancia
	private String nombre;
	private String raza;
	private String color;
	private String tamanio;
	private int edad;
	private float peso;
	
	// Metodos
	public void saltar() {
		System.out.println(this.getNombre()+" esta saltando");
	}
	
	public void caminar() {
		System.out.println(this.getNombre()+" esta caminando");
	}
	
	public void comer() {
		System.out.println(this.getNombre()+" esta comiendo");
	}
	
	public static void ladrar() {
		System.out.println("Gua Guau");
	}

	
	
	// Encapsulamiento
	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		if(edad <= 0 || edad > EDAD_MAXIMA) {
			throw new Exception(messageError);
		} else {
			this.edad = edad;
		}
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	
	public void mostrarAtributos() {
		System.out.println("Mi Perro " + this.getNombre() + " es un " + this.getRaza()
		+ " de color " + this.getColor() + ", es de Tamaño " + this.getTamanio()
		+ ", tiene " + this.getEdad() + " años de edad, y pesa " + this.getPeso() + " Kg");
	}
	
	@Override
	public String toString() {
		return "Perro [Nombre=" + nombre + ", Raza=" + raza + ", Color=" + color + ", Tamaño=" + tamanio + ", Edad="
				+ edad + " años, Peso=" + peso + " Kg]";
	}
	
	
	
}
