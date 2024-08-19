package com.conectarural.conecta_rural.exceptions;

public class FalhaCandidaturaException extends  Exception{
    public FalhaCandidaturaException(){}

    public FalhaCandidaturaException(String message){
        super("Não foi possível se candidatar! ");
    }
}
