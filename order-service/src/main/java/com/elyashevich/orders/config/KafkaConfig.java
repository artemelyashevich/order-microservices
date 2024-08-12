package com.elyashevich.orders.config;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.KafkaUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableKafka
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServers;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        final Map<String, Object> config = new HashMap<>(5);

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.kafkaServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "main_topic");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put("spring.json.trusted.packages", "*");

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        final ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.consumerFactory());
        return factory;
    }

    @Bean
    public DefaultErrorHandler errorHandler(
            KafkaTemplate<String, String> template) {
        return new DefaultErrorHandler() {
            @Override
            public void handleRemaining(
                    @NonNull
                    Exception ex,
                    @NonNull
                    java.util.List<ConsumerRecord<?, ?>> records,
                    @NonNull
                    Consumer<?, ?> consumer,
                    @NonNull
                    MessageListenerContainer container
            ) {
                log.warn("##: " + records.size());
                log.warn("ex: " + ex.getMessage());
                final ConsumerRecord<?, ?> cr = records.get(0);
                log.warn("ku: " + KafkaUtils.format(cr));
                log.warn("st: " + cr.toString());
                log.warn("key: " + cr.key());
                log.warn("val: " + cr.value());
                log.warn("vsz: " + cr.serializedValueSize());
            }
        };
    }
}
