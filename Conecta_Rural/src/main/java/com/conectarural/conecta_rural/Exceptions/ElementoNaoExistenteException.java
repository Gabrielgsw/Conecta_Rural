package com.conectarural.conecta_rural.Exceptions;

public class ElementoNaoExistenteException extends Exception{

    public ElementoNaoExistenteException() {
    }

    public ElementoNaoExistenteException(String message) {
        super("O Elemento Não Existe");
    }
}
