package br.com.all.zip.application.address.usecase;

import br.com.all.zip.domain.viaCep.ViaCepAddress;

import java.util.List;

public interface FindCepViaCepUseCase {
    List<ViaCepAddress> execute(String cep);
}
