package com.nttdata.bootcam.banca.consulta.producto.infrastructure;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.ClientCreatedEvent;
import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.Event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientEventsService {

	
	@KafkaListener(topics = "catalog-request-topic",
			containerFactory = "kafkaListenerContainerFactory",
			groupId = "my-group")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(ClientCreatedEvent.class)) {
			ClientCreatedEvent clientCreatedEvent = (ClientCreatedEvent) event;
			System.out.println("Received Customer created event .... with Id={}, data={}"+"//"+
					clientCreatedEvent.getId()+"//"+
					clientCreatedEvent.getData().toString() );
			log.info("Received Customer created event .... with Id={}, data={}",
					clientCreatedEvent.getId(),
					clientCreatedEvent.getData().toString());
		}

	}
	
	
}
