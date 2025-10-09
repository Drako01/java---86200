package com.coderhouse.entities;

import com.coderhouse.excepciones.EdadMascotaException;

public class Mascota {

	static final int EDAD_MAXIMA = 15;
	
	String messageError = "La Mascota no vive mas de " + EDAD_MAXIMA + " años de edad";
		
	String message = "La mascota emitio un sonido";
	private String nombre;
	private String color;
	private String tamanio;
	private int edad;
	private float peso;
	
	public Mascota() {
		super();
	}
	
	

	public Mascota(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}



	public Mascota(String nombre, String color, String tamanio, int edad, float peso) throws EdadMascotaException {
		super();
		this.nombre = nombre;
		this.color = color;
		this.tamanio = tamanio;
		this.edad = setEdad(edad);
		this.peso = peso;
	}
	
	
	public void caminar() {
		System.out.println(this.getNombre() + " esta caminando.!");
	}

	public void comer() {
		System.out.println(this.getNombre() + " esta comiendo.!");
	}
	
	public void dormir() {
		System.out.println(this.getNombre() + " esta durmiendo.!");
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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



	public String getMessageError() {
		return messageError;
	}



	public int setEdad(int edad) throws EdadMascotaException {
		if(edad <= 0 || edad > EDAD_MAXIMA) {
			throw new EdadMascotaException(messageError);
		}
		return this.edad = edad;
	}



	public float getPeso() {
		return peso;
	}


	
	public void setPeso(float peso) {
		this.peso = peso;
	}


	public void hacerSolido() {
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", color=" + color + ", tamanio=" + tamanio + ", edad="
				+ edad + ", peso=" + peso + "]";
	}
	
	
	
}
