package com.erickmarques.ms_customer_and_transfers.controller;

import com.erickmarques.ms_customer_and_transfers.dto.TransferCreateDto;
import com.erickmarques.ms_customer_and_transfers.dto.TransferResponseDto;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ITransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final ITransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<TransferResponseDto> transfer(@RequestBody @Valid TransferCreateDto dto) {
        return ResponseEntity.ok(transferService.transfer(dto));
    }
}