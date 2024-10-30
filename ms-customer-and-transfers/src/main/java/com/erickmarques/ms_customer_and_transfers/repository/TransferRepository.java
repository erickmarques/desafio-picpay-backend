package com.erickmarques.ms_customer_and_transfers.repository;

import com.erickmarques.ms_customer_and_transfers.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
