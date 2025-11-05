package br.com.all.zip.domain.states;

import java.util.List;
import java.util.Optional;

public interface StateRepository {
    List<State> findAll();
    Optional<State> findById(Integer id);

}
