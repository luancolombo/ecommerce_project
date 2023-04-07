package com.comerce.ecomerce.services;

import com.comerce.ecomerce.models.Address;
import com.comerce.ecomerce.repositories.AddressRepository;
import com.comerce.ecomerce.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Address saveAddress(Address address) {
        return repository.save(address);
    }
    public List<Address> findAll() {
        return repository.findAll();
    }
    public Address findById(Long id) {
        Optional<Address> client = repository.findById(id);
        return client.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
}
