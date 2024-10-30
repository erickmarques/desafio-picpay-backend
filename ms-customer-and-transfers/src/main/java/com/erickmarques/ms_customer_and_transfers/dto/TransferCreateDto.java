package com.erickmarques.ms_customer_and_transfers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferCreateDto(@NotNull(message = "Favor informar o valor!")
                                @DecimalMin(value = "0.01", inclusive = true, message = "O valor deve ser positivo e maior que zero!")
                                BigDecimal value,
                                @NotNull(message = "Favor informar o pagador!") Long payer,
                                @NotNull(message = "Favor informar o beneficiário!") Long payee) {
}
