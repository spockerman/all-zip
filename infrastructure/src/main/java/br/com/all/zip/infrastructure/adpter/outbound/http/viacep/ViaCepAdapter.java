package br.com.all.zip.infrastructure.adpter.outbound.http.viacep;

import br.com.all.zip.domain.viaCep.ViaCepAddress;
import br.com.all.zip.domain.viaCep.ViaCepLookupPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;


@Component
public class ViaCepAdapter implements ViaCepLookupPort {
    private final WebClient client;


    public ViaCepAdapter(WebClient.Builder builder) {
        this.client = builder.baseUrl("https://viacep.com.br/ws").build();
    }

    @Override
    public ViaCepAddress findCep(String cep) {
        String sanitized = cep == null ? null : cep.replaceAll("\\D", "");
        if(sanitized == null || sanitized.length() != 8) {
            throw new IllegalArgumentException("Invalid zip code" + cep);
        }

        var dto = client.get()
                .uri("/{sanitized}/json/", sanitized)
                .retrieve()
                .bodyToMono(ViaCepAddressResponse.class)
                .block(Duration.ofSeconds(3));

        if (dto == null || Boolean.TRUE.equals(dto.erro())) {
            throw new IllegalArgumentException("Zip code not found: " + cep);
        }

        return new ViaCepAddress(
                dto.cep,
                dto.logradouro,
                dto.unidade,
                dto.bairro,
                dto.localidade,
                dto.uf,
                dto.estado,
                dto.regiao,
                dto.ibge,
                dto.gia,
                dto.ddd,
                dto.siafi
        );

    }

    public record ViaCepAddressResponse(
            String cep,
            String logradouro,
            String unidade,
            String bairro,
            String localidade,
            String uf,
            String estado,
            String regiao,
            String ibge,
            String gia,
            String ddd,
            String siafi,
            Boolean erro
    ) {
    }
}
