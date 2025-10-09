package com.coderhouse.excepciones;

public class EdadMascotaException extends Exception {

	public EdadMascotaException(String message) {
		super("Ups.. "+message + ". Reintente setear la Edad");
	}

	
}
