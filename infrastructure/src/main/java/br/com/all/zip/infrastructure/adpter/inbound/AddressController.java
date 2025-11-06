package br.com.all.zip.infrastructure.adpter.inbound;

import br.com.all.zip.application.address.usecase.FindByAddressUseCase;
import br.com.all.zip.application.address.usecase.FindByZipCodeUseCase;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.AddressResponse;
import br.com.all.zip.infrastructure.adpter.inbound.rest.mapper.AddressMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final FindByAddressUseCase findByAddressUseCase;
    private final FindByZipCodeUseCase findByZipCodeUseCase;

    public AddressController(
            FindByAddressUseCase findByAddressUseCase,
            FindByZipCodeUseCase findByZipCodeUseCase
    ){
        this.findByAddressUseCase = findByAddressUseCase;
        this.findByZipCodeUseCase = findByZipCodeUseCase;
    }

    @GetMapping(params = "address")
    public ResponseEntity<List<AddressResponse>> findByAddress(@RequestParam String address){
        var response = findByAddressUseCase.execute(address).stream().map(
                AddressMapper::toResponse
        ).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(params = "zipCode")
    public ResponseEntity<List<AddressResponse>> findByZipCode(@RequestParam String zipCode){
        var response = findByZipCodeUseCase.execute(zipCode).stream().map(
                AddressMapper::toResponse
        ).toList();
        return ResponseEntity.ok(response);
    }

}

