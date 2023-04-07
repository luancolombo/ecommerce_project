package com.comerce.ecomerce.repositories;


import com.comerce.ecomerce.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
