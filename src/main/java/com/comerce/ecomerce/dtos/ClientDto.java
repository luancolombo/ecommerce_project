package com.comerce.ecomerce.dtos;


import javax.validation.constraints.NotBlank;

public class ClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
