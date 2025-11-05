package br.com.all.zip.application.state.service;

import br.com.all.zip.application.state.usecase.FindByIdStateUseCase;
import br.com.all.zip.domain.exception.StateNotFoundException;
import br.com.all.zip.domain.states.State;
import br.com.all.zip.domain.states.StateRepository;
import org.springframework.stereotype.Service;

@Service
public record FindByIdStateService(StateRepository repository) implements FindByIdStateUseCase {

    @Override
    public State execute(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new StateNotFoundException(id));
    }
}
