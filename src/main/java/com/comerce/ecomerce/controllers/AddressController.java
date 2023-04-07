package com.comerce.ecomerce.controllers;

import com.comerce.ecomerce.dtos.AddressDTO;
import com.comerce.ecomerce.models.Address;
import com.comerce.ecomerce.services.AddressService;
import com.comerce.ecomerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAllAddress() {
        List<Address> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Address address = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
    @PostMapping
    public ResponseEntity<Object> saveAddress(@RequestBody @Valid AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAddress(address));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {
        try {
            Address address = service.findById(id);
            address.setStreet(addressDTO.getStreet());
            address.setPostalCode(addressDTO.getPostalCode());
            address.setCity(addressDTO.getCity());
            address.setCountry(addressDTO.getCountry());
            return ResponseEntity.status(HttpStatus.OK).body(service.saveAddress(address));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable(value = "id") Long id) {
       Address address = service.findById(id);
       service.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully.");
    }
}
