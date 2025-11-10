package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.ReconcileStreetByZipCodeUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import br.com.all.zip.domain.address.StreetReconciliationPolicy;
import br.com.all.zip.domain.viaCep.ViaCepLookupPort;

import java.util.List;

public record ReconcileStreetByZipCodeService(
        AddressRepository repository,
        ViaCepLookupPort viaCepLookupPort,
        StreetReconciliationPolicy policy
) implements ReconcileStreetByZipCodeUseCase {

    @Override
    public List<Address> execute(String zipCode) {
        var opt = repository.findByZipCode(zipCode); // Optional<Address>
        if (opt.isEmpty()) return List.of();

        var addr = opt.get();
        var ext = viaCepLookupPort.findCep(zipCode);

        var decision = policy.decide(addr.getAddress(), ext.getLogradouro());
        if (decision.shouldUpdate()) {
            //ATUALIZA OS DADOS NA TABELA 'address_searchs criar o save update para atualizar os dados'
        }

        // mantém a assinatura retornando List<Address>
        return List.of(addr);
    }
}