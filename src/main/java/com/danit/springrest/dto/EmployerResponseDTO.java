package com.danit.springrest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployerResponseDTO {
    private Long id;
    private String name;
    private String address;
}

