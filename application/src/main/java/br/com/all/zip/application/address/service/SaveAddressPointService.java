package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.SaveAddressPointUseCase;
import br.com.all.zip.domain.AddressPoint.AddressPoint;
import br.com.all.zip.domain.AddressPoint.AddressPointRepository;
import org.springframework.stereotype.Service;

@Service
public record SaveAddressPointService(AddressPointRepository repository) implements SaveAddressPointUseCase {

    @Override
    public void execute(AddressPoint addressPoint) {
        repository.save(addressPoint);
    }
}
