package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.domain.cities.City;
import br.com.all.zip.domain.cities.CityRepository;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper.CityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private final JpaCityRepository repository;

    public CityRepositoryImpl(JpaCityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<City> findById(Integer id) {
        return repository.findById(id).map(CityMapper::toDomain);
    }

    @Override
    public List<City> findAll() {
        return repository.findAll().stream().map(CityMapper::toDomain).toList();
    }
}
