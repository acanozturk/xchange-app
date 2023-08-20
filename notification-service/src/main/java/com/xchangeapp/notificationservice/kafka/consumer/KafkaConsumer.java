package com.xchangeapp.notificationservice.kafka.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xchangeapp.notificationservice.email.Email;
import com.xchangeapp.notificationservice.email.data.FxRateEmailData;
import com.xchangeapp.notificationservice.kafka.util.TopicUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.SortedMap;

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
    public void consume(String message) {
        final Gson gson = new Gson();
        final JsonObject messageJson = gson.fromJson(message, JsonObject.class);
        final FxRateEmailData fxRateEmailData = new FxRateEmailData(
                messageJson.get("base_code").getAsString(),
                gson.fromJson(messageJson.get("conversion_rates").getAsJsonObject(), SortedMap.class)
        );

        email.sendEmail("fxRateEmail.ftl", fxRateEmailData);
    }

}
