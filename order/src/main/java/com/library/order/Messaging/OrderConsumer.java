package com.library.order.Messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    
    @KafkaListener(topics = "order-accepted", groupId = "order-consumer-group")
    public void consumeOrderAccepted(String message){
        System.out.println("Recebendo Mensagem Pedido Aceito");
        System.out.println(message);
        
    }

}
