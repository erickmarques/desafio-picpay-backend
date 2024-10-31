package com.erickmarques.ms_customer_and_transfers.client;

import com.erickmarques.ms_customer_and_transfers.dto.AuthorizationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "AuthorizationClient",
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponseDto> isAuthorized();
}
