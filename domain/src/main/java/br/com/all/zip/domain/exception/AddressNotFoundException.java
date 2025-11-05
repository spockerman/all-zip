package br.com.all.zip.domain.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String zipcode) {
        super("Address with id "+ zipcode + " not found.");
    }
}
