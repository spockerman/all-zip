package br.com.all.zip.application.state.usecase;

import java.util.List;
import br.com.all.zip.domain.states.State;

public interface FindAllStateUseCase {
    List<State> execute();
}
