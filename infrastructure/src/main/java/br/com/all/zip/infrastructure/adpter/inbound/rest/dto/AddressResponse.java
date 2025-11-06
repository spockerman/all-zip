package br.com.all.zip.infrastructure.adpter.inbound.rest.dto;

public record AddressResponse (
        Integer id,
        String address,
        String postalCode,
        String latitude,
        String longitude,
        Integer cityId,
        Integer districtId
) {}
