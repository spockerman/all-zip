package br.com.all.zip.domain.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Integer id) {
        super("City with id "+ id + "not found.");
    }
}
