package br.com.all.zip.application.state.service;

import br.com.all.zip.application.state.usecase.FindAllStateUseCase;
import br.com.all.zip.domain.states.State;
import br.com.all.zip.domain.states.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record FindAllStateService(StateRepository repository) implements FindAllStateUseCase {

    @Override
    public List<State> execute() { return repository.findAll();}
}
