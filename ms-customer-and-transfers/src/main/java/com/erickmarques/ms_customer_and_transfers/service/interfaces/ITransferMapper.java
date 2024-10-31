package com.erickmarques.ms_customer_and_transfers.service.interfaces;

import com.erickmarques.ms_customer_and_transfers.dto.TransferCreateDto;
import com.erickmarques.ms_customer_and_transfers.dto.TransferResponseDto;
import com.erickmarques.ms_customer_and_transfers.entity.Customer;
import com.erickmarques.ms_customer_and_transfers.entity.Transfer;
import com.erickmarques.ms_customer_and_transfers.entity.TransferStatus;

public interface ITransferMapper {
    Transfer toEntity(TransferCreateDto dto, Customer payer, Customer payee, TransferStatus status);

    TransferResponseDto toDto(Transfer transfer);
}
