package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCityRepository extends JpaRepository<JpaCityEntity, Integer> {
}
