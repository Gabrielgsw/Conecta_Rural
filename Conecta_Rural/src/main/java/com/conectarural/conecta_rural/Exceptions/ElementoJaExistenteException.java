package com.conectarural.conecta_rural.Exceptions;

public class ElementoJaExistenteException extends Exception{

    public ElementoJaExistenteException() {
    }

    public ElementoJaExistenteException(String message) {
        super("Elemento ja existente");
    }
}
