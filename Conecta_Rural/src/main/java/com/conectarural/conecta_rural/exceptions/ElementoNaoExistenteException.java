package com.conectarural.conecta_rural.exceptions;

public class ElementoNaoExistenteException extends Exception{

    public ElementoNaoExistenteException() {
    }

    public ElementoNaoExistenteException(String message) {
        super("O Elemento Não Existe");
    }
}
