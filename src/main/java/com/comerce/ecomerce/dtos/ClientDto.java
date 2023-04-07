package com.comerce.ecomerce.dtos;


import com.comerce.ecomerce.models.Address;

import javax.validation.constraints.NotBlank;

public class ClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String fiscalNumber;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
