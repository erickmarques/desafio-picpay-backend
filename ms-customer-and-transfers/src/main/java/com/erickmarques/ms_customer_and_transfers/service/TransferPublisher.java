package com.erickmarques.ms_customer_and_transfers.service;

import com.erickmarques.ms_customer_and_transfers.config.RabbitMqConfig;
import com.erickmarques.ms_customer_and_transfers.entity.Transfer;
import com.erickmarques.ms_customer_and_transfers.service.interfaces.ITransferPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TransferPublisher implements ITransferPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper mapper;

    @Override
    public void publishTransfer(Transfer transfer) {
        try {
            rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(transfer));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
