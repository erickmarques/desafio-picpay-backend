package com.erickmarques.ms_customer_and_transfers.service;

import com.erickmarques.ms_customer_and_transfers.dto.TransferCreateDto;
import com.erickmarques.ms_customer_and_transfers.dto.TransferResponseDto;
import com.erickmarques.ms_customer_and_transfers.entity.Customer;
import com.erickmarques.ms_customer_and_transfers.entity.Transfer;
import com.erickmarques.ms_customer_and_transfers.entity.TransferStatus;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ITransferMapper;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper implements ITransferMapper {

    @Override
    public Transfer toEntity(TransferCreateDto dto, Customer payer, Customer payee, TransferStatus status) {
        return Transfer.builder()
                .amount(dto.value())
                .payer(payer)
                .payee(payee)
                .status(status)
                .build();
    }

    @Override
    public TransferResponseDto toDto(Transfer transfer) {
        return TransferResponseDto.builder()
                .transaction(transfer.getId())
                .status(transfer.getStatus())
                .build();
    }
}
