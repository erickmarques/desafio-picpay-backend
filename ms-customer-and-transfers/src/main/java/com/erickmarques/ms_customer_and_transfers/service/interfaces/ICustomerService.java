package com.erickmarques.ms_customer_and_transfers.service.interfaces;

import com.erickmarques.ms_customer_and_transfers.entity.Customer;

import java.math.BigDecimal;

public interface ICustomerService {
    boolean hasSufficientBalance(Customer customer, BigDecimal amount);
    boolean isMerchant(Customer customer);
    Customer getCustomer(Long id);
}
