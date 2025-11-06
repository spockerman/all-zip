package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.domain.states.State;
import br.com.all.zip.domain.states.StateRepository;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaStateEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper.StateMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StateRepositoryImpl implements StateRepository {

    private final JpaStateRepository repository;

    public StateRepositoryImpl(JpaStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<State> findAll() {
        List<JpaStateEntity> entities = repository.findAll();

        return entities.stream()
                .map(StateMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<State> findById(Integer id) {
        return repository.findById(id).map(StateMapper::toDomain);
    }
}
