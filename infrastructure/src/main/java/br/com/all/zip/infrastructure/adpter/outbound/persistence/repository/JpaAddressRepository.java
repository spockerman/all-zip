package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface JpaAddressRepository extends JpaRepository<JpaAddressEntity, Integer> {
    Optional<JpaAddressEntity> findByPostalCode(String zipCode);
    List<JpaAddressEntity> findByAddress(String address);

}
