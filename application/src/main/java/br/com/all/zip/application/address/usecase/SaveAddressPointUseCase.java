package br.com.all.zip.application.address.usecase;

import br.com.all.zip.domain.AddressPoint.AddressPoint;

public interface SaveAddressPointUseCase {
    void execute(AddressPoint addressPoint);
}
