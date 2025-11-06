package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.domain.address.Address;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaCityEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaDistrictEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

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
        Integer cityId = (entity.getCity() != null ? entity.getCity().getId() : null);
        Integer districtId = (entity.getDistrict() != null ? entity.getDistrict().getId() : null);

        return Address.with(
                entity.getId(),
                cityId,
                districtId,
                entity.getAddress(),
                entity.getPostalCode(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDdd()
        );
    }
}
