package br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper;

import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaStateEntity;

import br.com.all.zip.domain.states.State;

public class StateMapper {

    public static JpaStateEntity toEntity(State state){
        JpaStateEntity entity = new JpaStateEntity();

        entity.setId(state.getId());
        entity.setName(state.getName());
        entity.setInitials(state.getInitials());

        return entity;
    }

    public static State toDomain(JpaStateEntity entity){
        return State.with(
                entity.getId(),
                entity.getName(),
                entity.getInitials()
        );
    }
}
