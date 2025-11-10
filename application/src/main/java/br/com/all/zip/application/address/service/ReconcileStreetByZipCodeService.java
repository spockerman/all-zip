package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.ReconcileStreetByZipCodeUseCase;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import br.com.all.zip.domain.address.StreetReconciliationPolicy;
import br.com.all.zip.domain.viaCep.ViaCepLookupPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ReconcileStreetByZipCodeService(
        AddressRepository repository,
        ViaCepLookupPort viaCepLookupPort,
        StreetReconciliationPolicy policy
) implements ReconcileStreetByZipCodeUseCase {

    @Override
    public List<Address> execute(String zipCode) {
        var opt = repository.findByZipCode(zipCode);

        if (opt.isEmpty()) return List.of();

        var addr = opt.get();
        var ext = viaCepLookupPort.findCep(zipCode);

        var decision = policy.decide(addr.getAddress(), ext.getLogradouro());
        if (decision.shouldUpdate()) {
            var updated = Address.with(
                    addr.getId(),
                    addr.getCityId(),
                    addr.getCityName(),
                    addr.getDistrictId(),
                    addr.getDistrictName(),
                    ext.getLogradouro(),
                    addr.getPostalCode(),
                    addr.getLatitude(),
                    addr.getLongitude(),
                    addr.getDdd()
            );

            repository.save(updated);

            return List.of(updated);

        }
        return List.of(addr);
    }
}