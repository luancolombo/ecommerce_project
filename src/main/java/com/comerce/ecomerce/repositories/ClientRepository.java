package com.comerce.ecomerce.repositories;

import com.comerce.ecomerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
