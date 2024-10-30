package com.erickmarques.ms_customer_and_transfers.repository;

import com.erickmarques.ms_customer_and_transfers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCpf(String cpf);

    Optional<Customer> findByCnpj(String cnpj);

    Optional<Customer> findByEmailIgnoreCase(String email);
}
