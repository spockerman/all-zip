package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper.AddressMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final JpaAddressRepository repository;
    private final AddressMapper mapper;

    public AddressRepositoryImpl(JpaAddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Address> findByZipCode(String zipCode) {
        return repository.findByPostalCode(zipCode).map(mapper::toDomain);
    }

    @Override
    public List<Address> findByAddress(String address) {
        List<JpaAddressEntity> resp = repository.findByAddress(address);
        return resp.stream().map(mapper::toDomain).toList();
    }

    @Override
    public void save(Address address) {
        JpaAddressEntity entity = mapper.toEntity(address);
        repository.save(entity);
    }
}
