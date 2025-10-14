package com.coderhouse.entities;

import com.coderhouse.abstractas.Vehiculo;

public class Moto extends Vehiculo {

	@Override
	protected void encender() {
		System.out.println("Mi Moto " + this.getMarca() + " esta encendiendo");
	}

	@Override
	protected void apagar() {
		System.out.println("Mi Moto " + this.getMarca() + " se esta apagando");
	}

	@Override
	protected void mover() {
		System.out.println("Mi Moto " + this.getMarca() + " se esta moviendo");
	}

	@Override
	public void mostrarCantidadDeRuedas() {
		System.out.println("Mi Moto " + this.getMarca() + " tiene "
				+ this.getRuedas() + " ruedas, y es de color: " + this.getColor());
	}

	@Override
	public String toString() {
		return "Moto [marca=" + super.marca + ", modelo=" + super.modelo + ", color=" 
				+ super.color + ", ruedas=" + super.ruedas + "]";
	}
	
	
}
