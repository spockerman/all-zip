package br.com.all.zip.infrastructure.adpter.inbound.rest.mapper;

import br.com.all.zip.domain.AddressPoint.AddressPoint;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.AddressPointRequest;

import java.util.Date;

public class AddressPointMapper {
    public static AddressPoint toDomain(AddressPointRequest request) {
        Date now = new Date();

        return AddressPoint.with(
                null, // ID nulo, será gerado na persistência
                request.addressId(),
                request.number(),
                request.complement(),
                request.referenceNote(),
                request.postalCode(),
                request.latitude(),
                request.longitude(),
                now,
                now
        );
    }

}
