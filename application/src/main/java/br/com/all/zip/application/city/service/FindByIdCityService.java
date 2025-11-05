package br.com.all.zip.application.city.service;

import br.com.all.zip.application.city.usecase.FindByIdCityUseCase;
import br.com.all.zip.domain.cities.City;
import br.com.all.zip.domain.cities.CityRepository;
import br.com.all.zip.domain.exception.CityNotFoundException;

public record FindByIdCityService(CityRepository repository) implements FindByIdCityUseCase {

    @Override
    public City execute(Integer id) {
        return repository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }
}
