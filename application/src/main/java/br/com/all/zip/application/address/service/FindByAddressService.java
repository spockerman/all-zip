package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.FindByAddressUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record FindByAddressService(AddressRepository repository) implements FindByAddressUseCase {

    @Override
    public List<Address> execute(String address) {
        return repository.findByAddress(address);
    }
}
