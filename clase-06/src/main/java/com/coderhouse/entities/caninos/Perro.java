package com.coderhouse.entities.caninos;

import com.coderhouse.entities.Mascota;
import com.coderhouse.interfaces.PerroInterface;

public class Perro extends Mascota implements PerroInterface {
	
	
	
	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comer() {
		System.out.println("Mi Perro " + super.getNombre() + " esta comiendo alimento Balanceado.!");
	}
	
	@Override
	public void caminar() {
		System.out.println("Mi Perro " + super.getNombre()  + " esta caminando en la Plaza.!");
	}

	@Override
	public void olfatear() {
		System.out.println("Mi Perro " + super.getNombre()  + " esta olfateando la Comida.!");
		
	}

	@Override
	public void ladrar() {
		System.out.println("Mi Perro " + super.getNombre()  + " le esta ladrando al vecino.!");
	}

	@Override
	public void moverLaCola() {
		System.out.println("Mi Perro " + super.getNombre()  + " le esta moviendo la Cola a mi hijo.!");
	}
	
	@Override
	public void jugar() {
		System.out.println("Mi Perro " + super.getNombre()  + " esta jugando con mi hijo.!");
	}
	
	@Override
	public void respirar() {
		if(super.estaVivo()) {			
			System.out.println("Mi Perro " + super.getNombre()  + " por suerte esta Respirando.!");
		} else {
			System.err.println("Mi Perro " + super.getNombre()  + " acaba de Fallecer.!");
		}
	}

	@Override
	public String toString() {
		return "Mi Perro " + super.getNombre()  + " esta Feliz";
	}

	
}
