package br.com.all.zip.infrastructure.adpter.inbound.rest.mapper;

import br.com.all.zip.domain.address.Address;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.AddressResponse;

public class AddressMapper {
    public static AddressResponse toResponse(Address address){
        return new AddressResponse(
                address.getId(),
                address.getAddress(),
                address.getPostalCode(),
                address.getLatitude(),
                address.getLongitude(),
                address.getCityId(),
                address.getDistrictId()
        );
    }
}
