package br.com.all.zip.domain.cities;

import java.util.List;
import java.util.Optional;


public interface CityRepository {
    Optional <City> findById(Integer id);
    List<City> findAll();

}
