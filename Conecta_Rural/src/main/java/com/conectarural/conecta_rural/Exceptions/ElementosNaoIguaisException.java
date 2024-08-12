package com.conectarural.conecta_rural.Exceptions;

public class ElementosNaoIguaisException extends Exception {
    public ElementosNaoIguaisException() {
    }

    public ElementosNaoIguaisException(String message) {
        super("Os Elementos Não São Iguais");
    }
}
