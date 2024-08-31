package com.library.order.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.library.order.Messaging.OrderProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class KafkaController {
    
@Autowired
private OrderProducerService orderProducerService;

@PostMapping("/send")
public String postMethodName(@RequestBody String message) {

    orderProducerService.sendMessage(message, "order-accepted");
    
    return "Mesagem enviada com Sucesso!";
}


}
