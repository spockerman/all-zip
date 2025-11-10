package br.com.all.zip.infrastructure.adpter.inbound;

import br.com.all.zip.application.address.service.SaveAddressPointService;
import br.com.all.zip.domain.AddressPoint.AddressPoint;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.AddressPointRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static br.com.all.zip.infrastructure.adpter.inbound.rest.mapper.AddressPointMapper.toDomain;

@RestController
@RequestMapping("/address-point")
public class AddressPointController {

    private final SaveAddressPointService saveAddressPointService;

    public AddressPointController(SaveAddressPointService saveAddressPointService) {
        this.saveAddressPointService = saveAddressPointService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAddressPoint(@RequestBody AddressPointRequest request) {
        AddressPoint domain = toDomain(request);
        saveAddressPointService.execute(domain);
    }
}
