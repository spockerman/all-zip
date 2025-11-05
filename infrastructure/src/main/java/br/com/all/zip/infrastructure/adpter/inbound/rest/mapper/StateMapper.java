package br.com.all.zip.infrastructure.adpter.inbound.rest.mapper;

import br.com.all.zip.domain.states.State;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.StateResponse;

public class StateMapper {

    public static StateResponse toResponse(State state){
        return new StateResponse(
                state.getId(),
                state.getName(),
                state.getInitials()
        );
    }
}
