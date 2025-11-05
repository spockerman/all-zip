package br.com.all.zip.application.city.service;

import br.com.all.zip.application.city.usecase.FindAllCityUseCase;
import br.com.all.zip.domain.cities.City;
import br.com.all.zip.domain.cities.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record FindAllCityService(CityRepository repository) implements FindAllCityUseCase {

    @Override
    public List<City> execute() {
        return repository.findAll();
    }
}
