package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStateRepository extends JpaRepository<JpaStateEntity, Integer> {
}
