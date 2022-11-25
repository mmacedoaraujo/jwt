package com.mmacedoaraujo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String name;
    private Timestamp birthDate;
    private String cpf;
    private String street;
    private String city;
    private String state;
    private Integer cep;
    private Integer phoneNumber;
    private String email;
}
