package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.domain.address.Address;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaCityEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaDistrictEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressMapper {

    @PersistenceContext
    private  EntityManager entityManager;

    public  JpaAddressEntity toEntity(Address address){
        JpaAddressEntity entity = new JpaAddressEntity();

        entity.setId(address.getId());
        if(address.getCityId() != null){
            entity.setCity(entityManager.getReference(JpaCityEntity.class, address.getCityId()));
        }else{
            entity.setCity(null);
        }
        if(address.getDistrictId() != null){
            entity.setDistrict(entityManager.getReference(JpaDistrictEntity.class, address.getDistrictId()));
        }
        entity.setAddress(address.getAddress());
        entity.setPostalCode(address.getPostalCode());
        entity.setLatitude(address.getLatitude());
        entity.setLongitude(address.getLongitude());
        entity.setDdd(address.getDdd());

        return entity;
    }

    public static Address toDomain(JpaAddressEntity entity){
        if (entity == null) {
            return null;
        }

        Integer cityId = Optional.ofNullable(entity.getCity())
                .map(JpaCityEntity::getId)
                .orElse(null);

        String cityName = Optional.ofNullable(entity.getCity())
                .map(JpaCityEntity::getName)
                .orElse(null);

        Integer districtId = Optional.ofNullable(entity.getDistrict())
                .map(JpaDistrictEntity::getId)
                .orElse(null);

        String districtName = Optional.ofNullable(entity.getDistrict())
                .map(JpaDistrictEntity::getName)
                .orElse(null);
        return Address.with(
                entity.getId(),
                cityId,
                cityName,
                districtId,
                districtName,
                entity.getAddress(),
                entity.getPostalCode(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDdd()
        );
    }
}
