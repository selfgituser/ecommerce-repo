package com.ecom.carDetails.cartDetailsMicro.kafkaservices;

import com.ecom.carDetails.cartDetailsMicro.entity.cartItems;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.StringSerializer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemsProducerService {

    private static final String TOPIC = "cart-items";

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public CartItemsProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCartItem(List<cartItems> cartItemsList ) {
        try {
            // Serialize CartItem to JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String cartItemJson = objectMapper.writeValueAsString(cartItemsList);

            // Send to Kafka topic
            kafkaTemplate.send(TOPIC, "cartkey" ,cartItemJson);
            System.out.println("CartItem sent to Kafka: " + cartItemJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
