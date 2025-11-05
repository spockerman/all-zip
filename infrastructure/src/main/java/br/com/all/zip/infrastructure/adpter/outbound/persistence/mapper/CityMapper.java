package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaCityEntity;
import br.com.all.zip.domain.cities.City;

public class CityMapper {

    public static JpaCityEntity toEntity(City city){
        JpaCityEntity entity = new JpaCityEntity();

        entity.setId(city.getId());
        entity.setName(city.getName());
        entity.setStateId(city.getStateId());
        entity.setSlug(city.getSlug());

        return entity;
    }

    public static City toDomain(JpaCityEntity entity){
        return City.with(
                entity.getId(),
                entity.getName(),
                entity.getStateId(),
                entity.getSlug()
        );
    }
}
