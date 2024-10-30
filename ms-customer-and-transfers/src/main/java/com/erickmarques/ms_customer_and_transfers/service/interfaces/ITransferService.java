package com.erickmarques.ms_customer_and_transfers.service.interfaces;

import com.erickmarques.ms_customer_and_transfers.dto.TransferCreateDto;
import com.erickmarques.ms_customer_and_transfers.dto.TransferResponseDto;

public interface ITransferService {
    TransferResponseDto transfer(TransferCreateDto transferCreateDto);
}
