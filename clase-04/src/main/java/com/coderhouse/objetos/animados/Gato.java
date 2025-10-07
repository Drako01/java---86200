package com.coderhouse.objetos.animados;

public class Gato {

	private String nombre;
	private String tamanio;
	private int edad;
	
	
	public static void mauyar() {
		System.out.println("Miau Miau");
	}

	public void comer() {
		System.out.println(this.getNombre() + " esta Comiendo.");
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Gato [nombre=" + nombre + ", tamanio=" + tamanio + ", edad=" + edad + "]";
	}
	
	
}
