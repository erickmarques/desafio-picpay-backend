package com.erickmarques.ms_customer_and_transfers.service;

import com.erickmarques.ms_customer_and_transfers.client.AuthorizationClient;
import com.erickmarques.ms_customer_and_transfers.dto.AuthorizationResponseDto;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.IAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements IAuthorizationService {
    private final AuthorizationClient authorizationClient;

    @Override
    public boolean isAuthorized() {
        try {
            var response = authorizationClient.isAuthorized();
            return isResponseSuccessful(response);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isResponseSuccessful(ResponseEntity<AuthorizationResponseDto> response) {
        return response != null &&
                response.getStatusCode().is2xxSuccessful() &&
                response.getBody() != null &&
                response.getBody().data() != null &&
                response.getBody().data().authorization();
    }
}
