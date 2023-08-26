package com.xchangeapp.notificationservice.kafka.consumer;

import com.xchangeapp.notificationservice.email.Email;
import com.xchangeapp.notificationservice.kafka.util.TopicUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final Email email;

    @KafkaListener(
            topics = TopicUtil.FX_RATES_TOPIC,
            groupId = TopicUtil.EMAIL_CONSUMER_GROUP,
            containerFactory = TopicUtil.CONTAINER_FACTORY
    )
    public void consume(Object message) {
        email.sendEmail("fxRateEmail.ftl", message);
    }

}
