package com.comerce.ecomerce.dtos;

import com.comerce.ecomerce.models.Client;

import javax.validation.constraints.NotBlank;

public class AddressDTO {
    @NotBlank
    private String street;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String country;

    private Client client;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
