package br.com.all.zip.application.address.usecase;

import br.com.all.zip.domain.address.Address;

import java.util.List;

public interface FindByZipCodeUseCase {
    List<Address> execute(String zipCode);
}
