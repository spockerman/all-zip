package br.com.all.zip.application.address.usecase;

import br.com.all.zip.domain.address.Address;

import java.util.List;

public interface ReconcileStreetByZipCodeUseCase {
    List<Address> execute(String zipCode);
}
