package com.xchangeapp.notificationservice.kafka.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TopicUtil {
    
    public final String FX_RATES_TOPIC = "xchange-app-fx-rates";
    public final String EMAIL_CONSUMER_GROUP = "email-consumer-group";
    public final String CONTAINER_FACTORY = "kafkaListenerContainerFactory";
    
}
