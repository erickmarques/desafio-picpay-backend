package com.erickmarques.ms_customer_and_transfers.dto;

public record AuthorizationResponseDto(String status, Data data) {
    public record Data(boolean authorization) {}
}
