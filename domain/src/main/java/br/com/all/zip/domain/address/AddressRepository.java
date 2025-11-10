package br.com.all.zip.domain.address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    Optional<Address> findById(Integer id);
    Optional<Address> findByZipCode(String zipCode);
    List<Address> findByAddress(String address);
    void save(Address address);

}
