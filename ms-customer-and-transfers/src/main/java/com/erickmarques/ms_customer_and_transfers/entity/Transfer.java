package com.erickmarques.ms_customer_and_transfers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transferencias")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer extends AuditableEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_sender_id", nullable = false)
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "account_receiver_id", nullable = false)
    private Account receiver;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransferStatus status;
}
