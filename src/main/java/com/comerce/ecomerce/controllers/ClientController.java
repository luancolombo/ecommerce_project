package com.comerce.ecomerce.controllers;

import com.comerce.ecomerce.dtos.ClientDto;
import com.comerce.ecomerce.models.Client;
import com.comerce.ecomerce.services.ClientService;
import com.comerce.ecomerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Client client = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDTo) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTo, client);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveClient(client));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody @Valid ClientDto clientDto) {
        try {
            Client client = service.findById(id);
            client.setName(clientDto.getName());
            client.setFiscalNumber(clientDto.getFiscalNumber());
            client.setBirthDate(clientDto.getBirthDate());
            client.setEmail(clientDto.getEmail());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            client.setAddress(clientDto.getAddress());
            return ResponseEntity.status(HttpStatus.OK).body(service.saveClient(client));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") Long id) {
       Client client = service.findById(id);
       service.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully.");
    }
}
