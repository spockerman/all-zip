package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.FindByZipCodeUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import br.com.all.zip.domain.exception.AddressNotFoundException;

import java.util.Collections;
import java.util.List;

public record FindByZipCodeService(AddressRepository repository) implements FindByZipCodeUseCase {
    @Override
    public List<Address> execute(String zipCode) {
        return Collections.singletonList(repository.findByZipCode(zipCode)
                .orElseThrow(() -> new AddressNotFoundException(zipCode)));
    }
}
