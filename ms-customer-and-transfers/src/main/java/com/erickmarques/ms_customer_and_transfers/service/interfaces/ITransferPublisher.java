package com.erickmarques.ms_customer_and_transfers.service.interfaces;

import com.erickmarques.ms_customer_and_transfers.entity.Transfer;

public interface ITransferPublisher {
    void publishTransfer(Transfer transfer);
}
