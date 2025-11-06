package br.com.all.zip.infrastructure.adpter.inbound;

import br.com.all.zip.application.city.usecase.FindAllCityUseCase;
import br.com.all.zip.application.city.usecase.FindByIdCityUseCase;
import br.com.all.zip.infrastructure.adpter.inbound.rest.dto.CityResponse;
import br.com.all.zip.infrastructure.adpter.inbound.rest.mapper.CityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final FindAllCityUseCase findAllCityUseCase;
    private final FindByIdCityUseCase findByIdCityUseCase;


    public CityController(
            FindAllCityUseCase findAllCityUseCase,
            FindByIdCityUseCase findByIdCityUseCase
    ) {
        this.findAllCityUseCase = findAllCityUseCase;
        this.findByIdCityUseCase = findByIdCityUseCase;
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> findAll(){
        var response = findAllCityUseCase.execute().stream()
                .map(CityMapper::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> findById(@PathVariable("id") Integer id){
        var response = findByIdCityUseCase.execute(id);
        return ResponseEntity.ok(CityMapper.toResponse(response));
    }
}
