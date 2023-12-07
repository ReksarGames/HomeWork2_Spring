package com.danit.springrest.dto;

import com.danit.springrest.enums.Currency;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequestDTO {
    private String number;

    @NotNull(message = "Currency cannot be null")
    private Currency currency;

    @NotNull(message = "Balance cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance can be negative")
    private Double balance;

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;
}
