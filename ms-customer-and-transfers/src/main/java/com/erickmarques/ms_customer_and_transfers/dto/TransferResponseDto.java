package com.erickmarques.ms_customer_and_transfers.dto;

import com.erickmarques.ms_customer_and_transfers.entity.TransferStatus;
import lombok.Builder;

@Builder
public record TransferResponseDto(String transaction,
                                  TransferStatus status) {
}
