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

    public AddressRepositoryImpl(JpaAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return repository.findById(id).map(AddressMapper::toDomain);
    }

    @Override
    public Optional<Address> findByZipCode(String zipCode) {
        return repository.findByPostalCode(zipCode).map(AddressMapper::toDomain);
    }

    @Override
    public List<Address> findByAddress(String address) {
        List<JpaAddressEntity> resp = repository.findByAddress(address);
        return resp.stream().map(AddressMapper::toDomain).toList();
    }


}
