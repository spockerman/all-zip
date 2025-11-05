package br.com.all.zip.application.state.usecase;

import br.com.all.zip.domain.states.State;

public interface FindByIdStateUseCase {
    State execute(Integer id);
}
