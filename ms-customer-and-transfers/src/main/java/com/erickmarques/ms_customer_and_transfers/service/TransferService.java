package com.erickmarques.ms_customer_and_transfers.service;

import com.erickmarques.ms_customer_and_transfers.client.AuthorizationClient;
import com.erickmarques.ms_customer_and_transfers.dto.TransferCreateDto;
import com.erickmarques.ms_customer_and_transfers.dto.TransferResponseDto;
import com.erickmarques.ms_customer_and_transfers.entity.TransferStatus;
import com.erickmarques.ms_customer_and_transfers.repository.TransferRepository;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ICustomerService;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ITransferMapper;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ITransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TransferService implements ITransferService {

    private final TransferRepository transferRepository;
    private final ITransferMapper transferMapper;
    private final ICustomerService customerService;
    private final AuthorizationClient authorizationClient;

    @Override
    @Transactional
    public TransferResponseDto transfer(TransferCreateDto transferCreateDto) {

        var payer = customerService.getCustomer(transferCreateDto.payer());
        var payee = customerService.getCustomer(transferCreateDto.payee());

        // Verifica se o pagador tem saldo suficiente
        if (!customerService.hasSufficientBalance(payer, transferCreateDto.value())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente para a transferência.");
        }

        // Verifica se o pagador não é um lojista (apenas usuários comuns podem enviar dinheiro)
        if (customerService.isMerchant(payer)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Lojistas não podem realizar transferências.");
        }

        var transfer = transferMapper.toEntity(transferCreateDto, payer, payee, TransferStatus.PENDING);

        transferRepository.save(transfer);

        return transferMapper.toDto(transfer);
    }
}
