package com.danit.springrest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private List<AccountResponseDTO> accounts;
    private List<EmployerResponseDTO> employers;

}
