package com.xchangeapp.fxrateservice.kafka.producer;

import com.xchangeapp.fxrateservice.kafka.util.TopicUtil;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public void produce(String message) {
        kafkaTemplate.send(TopicUtil.FX_RATES_TOPIC, message);
    }
    
}
