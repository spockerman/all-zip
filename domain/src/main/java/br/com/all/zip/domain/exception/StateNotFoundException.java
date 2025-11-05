package br.com.all.zip.domain.exception;

public class StateNotFoundException extends RuntimeException{
    public StateNotFoundException(Integer id) {
        super("State with id "+ id + "not found.");
    }
}
