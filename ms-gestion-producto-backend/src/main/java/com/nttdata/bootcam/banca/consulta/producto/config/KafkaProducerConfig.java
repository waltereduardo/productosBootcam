package com.nttdata.bootcam.banca.consulta.producto.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.Event;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfig {

	private final String bootstrapAddress = "localhost:9092";

	@Bean
	public ConsumerFactory<String, Event<?>> consumerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		configProps.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, JsonDeserializer.class);
		configProps.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES,
				"com.nttdata.bootcam.banca.consulta.client.infraestructure.event");
//        props.put(JsonSerializer.TYPE_MAPPINGS, "com.nttdata.bootcam.banca.consulta.producto.infrastructure:com.nttdata.bootcam.banca.consulta.producto.infrastructure.event.Event");
//
//        final JsonDeserializer<Event<?>> jsonDeserializer = new JsonDeserializer<>();
//        
//        JsonDeserializer<Event<?>> jsonDeserializer = new JsonDeserializer<>(Event.class);
//        jsonDeserializer.addTrustedPackages("com.nttdata.bootcam.banca.consulta.producto.infrastructure");
//        
//        return new DefaultKafkaConsumerFactory(
//                props,
//                new StringDeserializer(),
//                jsonDeserializer);
		return new DefaultKafkaConsumerFactory<>(configProps);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Event<?>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Event<?>> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Event<?>>
//    kafkaListenerContainerFactory() {
//
//    	ConcurrentKafkaListenerContainerFactory<String, Event<?>> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

////    @Bean
//    public ProducerFactory<String, ProductoCatalogoKafka> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ProductoCatalogoKafkaSerializer.class); 
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, ProductoCatalogoKafka> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
