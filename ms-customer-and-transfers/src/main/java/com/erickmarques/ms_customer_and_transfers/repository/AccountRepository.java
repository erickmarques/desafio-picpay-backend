package com.erickmarques.ms_customer_and_transfers.repository;

import com.erickmarques.ms_customer_and_transfers.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
