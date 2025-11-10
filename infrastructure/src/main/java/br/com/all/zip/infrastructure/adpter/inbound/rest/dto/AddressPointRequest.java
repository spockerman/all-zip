package br.com.all.zip.infrastructure.adpter.inbound.rest.dto;

import java.util.Date;

public record AddressPointRequest(
        Integer id,
        Integer addressId,
        String number,
        String complement,
        String referenceNote,
        String postalCode,
        String latitude,
        String longitude
) {}
