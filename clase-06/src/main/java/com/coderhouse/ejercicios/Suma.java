package com.coderhouse.ejercicios;

import com.coderhouse.interfaces.OperableInterface;

public class Suma implements OperableInterface {
	private double a;
	private double b;
	
	
	
	
	public Suma(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Suma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public void enviarMensaje() {
		System.out.println("Ingrese dos numeros para Sumar");
	}

	@Override
	public double operar(double a, double b) {
		return a + b;
	}

	@Override
	public void enviarResultado() {
		System.out.println("El resultado de la Suma es: " + this.operar(this.a, this.b));

	}

}
