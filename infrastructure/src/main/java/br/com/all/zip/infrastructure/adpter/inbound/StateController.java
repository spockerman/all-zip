package br.com.all.zip.infrastructure.adpter.inbound;

import br.com.all.zip.application.state.usecase.FindAllStateUseCase;
import br.com.all.zip.application.state.usecase.FindByIdStateUseCase;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.StateResponse;
import br.com.all.zip.infrastructure.adpter.inbound.rest.mapper.StateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    private final FindAllStateUseCase findAllStateUseCase;
    private final FindByIdStateUseCase findByIdStateUseCase;

    public StateController(
            FindAllStateUseCase findAllStateUseCase,
            FindByIdStateUseCase findByIdStateUseCase
    ){
        this.findAllStateUseCase = findAllStateUseCase;
        this.findByIdStateUseCase = findByIdStateUseCase;
    }

    @GetMapping
    public ResponseEntity<List<StateResponse>> findAll(){
        var response = findAllStateUseCase.execute().stream()
                .map(StateMapper::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> findById(Integer id){
        var state = findByIdStateUseCase.execute(id);
        return ResponseEntity.ok(StateMapper.toResponse(state));
    }

}
