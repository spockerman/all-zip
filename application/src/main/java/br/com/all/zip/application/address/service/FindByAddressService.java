package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.FindByAddressUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;

import java.util.List;

public record FindByAddressService(AddressRepository repository) implements FindByAddressUseCase {

    @Override
    public List<Address> execute(String address) {
        return repository.findByAddress(address);
    }
}
