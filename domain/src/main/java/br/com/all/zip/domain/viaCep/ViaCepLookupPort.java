package br.com.all.zip.domain.viaCep;

public interface ViaCepLookupPort {
    ViaCepAddress findCep(String cep);
}
