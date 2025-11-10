package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.domain.AddressPoint.AddressPoint;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressPointEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressPointMapper {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaAddressPointEntity toEntity(AddressPoint address){
        if(address == null){ return null;}

        JpaAddressPointEntity entity = new JpaAddressPointEntity();
        entity.setId(address.getId());

        if(address.getAddressId() != null){
            entity.setAddress(entityManager.getReference(JpaAddressEntity.class, address.getAddressId()));
        }else{
            entity.setAddress(null);
        }

        entity.setNumber(address.getNumber());
        entity.setComplement(address.getComplement());
        entity.setReferenceNote(address.getReferenceNote());
        entity.setPostalCode(address.getPostalCode());
        entity.setLatitude(address.getLatitude());
        entity.setLongitude(address.getLongitude());
        entity.setCreatedAt(address.getCreatedAt());
        entity.setUpdatedAt(address.getUpdatedAt());

        return entity;
    }

    public AddressPoint toDomain(JpaAddressPointEntity entity){
        if (entity == null) {
            return null;
        }

        Integer addressId = Optional.ofNullable(entity.getAddress())
                .map(JpaAddressEntity::getId)
                .orElse(null);


        return AddressPoint.with(
                entity.getId(),
                addressId,
                entity.getNumber(),
                entity.getComplement(),
                entity.getReferenceNote(),
                entity.getPostalCode(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );

    }
}
