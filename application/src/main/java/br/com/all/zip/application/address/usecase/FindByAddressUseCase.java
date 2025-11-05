package br.com.all.zip.application.address.usecase;

import br.com.all.zip.domain.address.Address;

import java.util.List;

public interface FindByAddressUseCase {
    List<Address> execute(String address);
}
