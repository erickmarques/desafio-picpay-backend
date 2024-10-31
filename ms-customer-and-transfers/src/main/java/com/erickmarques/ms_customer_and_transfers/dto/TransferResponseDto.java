package com.erickmarques.ms_customer_and_transfers.dto;

import com.erickmarques.ms_customer_and_transfers.entity.TransferStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record TransferResponseDto(UUID transaction,
                                  TransferStatus status) {
}
