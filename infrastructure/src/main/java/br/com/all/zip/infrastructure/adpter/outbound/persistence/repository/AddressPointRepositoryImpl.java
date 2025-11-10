package br.com.all.zip.infrastructure.adpter.outbound.persistence.repository;

import br.com.all.zip.domain.AddressPoint.AddressPoint;
import br.com.all.zip.domain.AddressPoint.AddressPointRepository;
import br.com.all.zip.domain.address.Address;
import br.com.all.zip.domain.address.AddressRepository;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.entity.JpaAddressPointEntity;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper.AddressMapper;
import br.com.all.zip.infrastructure.adpter.outbound.persistence.mapper.AddressPointMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressPointRepositoryImpl implements AddressPointRepository {

    private final JpaAddressPointRepository repository;
    private final AddressPointMapper mapper;

    public AddressPointRepositoryImpl(JpaAddressPointRepository repository, AddressPointMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void save(AddressPoint addressPoint) {
        JpaAddressPointEntity entity = mapper.toEntity(addressPoint);
        repository.save(entity);
    }
}
