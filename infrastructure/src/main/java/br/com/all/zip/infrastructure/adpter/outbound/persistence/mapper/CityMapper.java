package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaCityEntity;
import br.com.all.zip.domain.cities.City;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaStateEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    @PersistenceContext
    private  EntityManager entityManager;

    public  JpaCityEntity toEntity(City city){
        JpaCityEntity entity = new JpaCityEntity();

        entity.setId(city.getId());
        entity.setName(city.getName());
        if(city.getStateId() != null){
            entity.setState(entityManager.getReference(JpaStateEntity.class, city.getStateId()));
        }else{
            entity.setState(null);
        }

        entity.setSlug(city.getSlug());

        return entity;
    }

    public static City toDomain(JpaCityEntity entity){
        Integer stateId = (entity.getState() != null ? entity.getState().getId() : null);
        return City.with(
                entity.getId(),
                entity.getName(),
                stateId,
                entity.getSlug()
        );
    }
}
