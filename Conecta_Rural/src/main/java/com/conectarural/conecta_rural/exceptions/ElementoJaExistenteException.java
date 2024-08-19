package com.conectarural.conecta_rural.exceptions;

public class ElementoJaExistenteException extends Exception{

    public ElementoJaExistenteException() {
    }

    public ElementoJaExistenteException(String message) {
        super("Elemento ja existente");
    }
}
