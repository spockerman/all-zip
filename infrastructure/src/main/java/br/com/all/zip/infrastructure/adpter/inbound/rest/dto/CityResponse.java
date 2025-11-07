package br.com.all.zip.infrastructure.adpter.inbound.rest.dto;

public record CityResponse(
        Integer id,
        String name,
        Integer stateId,
        String stateName,
        String slug
) {
}
