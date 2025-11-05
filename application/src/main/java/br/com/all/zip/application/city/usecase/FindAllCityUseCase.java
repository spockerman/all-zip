package br.com.all.zip.application.city.usecase;

import br.com.all.zip.domain.cities.City;

import java.util.List;

public interface FindAllCityUseCase {
    List<City> execute();
}
