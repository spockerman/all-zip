package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.ReconcileStreetByZipCodeUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;

import java.util.List;

public record ReconcileStreetByZipCodeService(
        AddressRepository repository,
        FindByZipCodeService findByZipCodeService
) implements ReconcileStreetByZipCodeUseCase {

    @Override
    public List<Address> execute(String zipCode) {
        return List.of();
    }
}
