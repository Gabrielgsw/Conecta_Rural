package com.conectarural.conecta_rural.Exceptions;

public class FalhaLoginException extends Exception {
    public FalhaLoginException() {
        super("E-mail ou senha incorretos, por favor, tente novamente!");
    }
}
