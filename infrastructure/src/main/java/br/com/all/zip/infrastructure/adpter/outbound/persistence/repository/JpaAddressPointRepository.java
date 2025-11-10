package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaAddressPointRepository extends JpaRepository<JpaAddressPointEntity, Integer> {}
