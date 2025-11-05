package br.com.all.zip.domain.exception;

public class ZipCodeNotFoundException extends RuntimeException{
    public ZipCodeNotFoundException(Integer id) {
        super("ZipCode with id "+ id + "not found.");
    }
}
