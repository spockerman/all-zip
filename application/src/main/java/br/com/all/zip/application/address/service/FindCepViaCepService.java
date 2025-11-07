package br.com.all.zip.application.address.service;

import br.com.all.zip.application.address.usecase.FindCepViaCepUseCase;
import br.com.all.zip.domain.viaCep.ViaCepAddress;
import br.com.all.zip.domain.viaCep.ViaCepLookupPort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public record FindCepViaCepService(ViaCepLookupPort viaCep) implements FindCepViaCepUseCase {
    @Override
    public List<ViaCepAddress> execute(String cep) {
        String sanitized = cep == null ? null : cep.replaceAll("\\D", "");
        if(sanitized == null || sanitized.length() != 8) {
            throw new IllegalArgumentException("Invalid zip code" + cep);
        }
        return viaCep.findCep(sanitized);
    }
}
