package com.comerce.ecomerce.services;

import com.comerce.ecomerce.models.Client;
import com.comerce.ecomerce.repositories.ClientRepository;
import com.comerce.ecomerce.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Client saveClient(Client client) {
        return repository.save(client);
    }
    public List<Client> findAll() {
        return repository.findAll();
    }
    public Client findById(Long id) {
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
