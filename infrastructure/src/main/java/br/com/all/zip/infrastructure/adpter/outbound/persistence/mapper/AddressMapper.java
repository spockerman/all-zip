package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.domain.address.Address;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;

public class AddressMapper {

    public static JpaAddressEntity toEntity(Address address){
        JpaAddressEntity entity = new JpaAddressEntity();

        entity.setId(address.getId());
        entity.setCityId(address.getCityId());
        entity.setStateId(address.getStateId());
        entity.setAddress(address.getAddress());
        entity.setPostalCode(address.getPostalCode());
        entity.setLatitude(address.getLatitude());
        entity.setLongitude(address.getLongitude());
        entity.setDdd(address.getDdd());

        return entity;
    }

    public static Address toDomain(JpaAddressEntity entity){
        return Address.with(
                entity.getId(),
                entity.getCityId(),
                entity.getStateId(),
                entity.getAddress(),
                entity.getPostalCode(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDdd()
        );
    }
}
