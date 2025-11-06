package br.com.all.zip.infrastructure.adpter.inbound.rest.mapper;

import br.com.all.zip.domain.cities.City;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.CityResponse;

public class CityMapper {

    public static CityResponse toResponse(City city){
        return new CityResponse(
                city.getId(),
                city.getName(),
                city.getStateId(),
                city.getSlug()
        );
    }
}
