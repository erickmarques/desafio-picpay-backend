package com.erickmarques.ms_customer_and_transfers.service;

import com.erickmarques.ms_customer_and_transfers.entity.Customer;
import com.erickmarques.ms_customer_and_transfers.entity.UserType;
import com.erickmarques.ms_customer_and_transfers.repository.CustomerRepository;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private  final CustomerRepository customerRepository;

    @Override
    public boolean hasSufficientBalance(Customer customer, BigDecimal amount) {
        return customer.getBalance().compareTo(amount) >= 0;
    }

    @Override
    public boolean isMerchant(Customer customer) {
        return customer.getCustomerType().getUserType().equals(UserType.MERCHANT);
    }

    public Customer getCustomer(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cliente para o ID informado!"));
    }
}
