package com.nttdata.bootcam.banca.consulta.producto.infrastructure;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.dto.event.ClientCatalogEvent;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servicio que verifica la existencia de mensajes, en el topico de catalogos, a
 * partir de su identificador unico.
 * 
 * @author wrodrigr
 */
@Service
public class ClientMessageCatalogService {

	@Autowired
	private ConsumerFactory<String, ClientCatalogEvent> consumerFactory;

	public boolean checkIfMessageExistsInTopic(String messageId) {
		try {
			Consumer<String, ClientCatalogEvent> kafkaConsumer = consumerFactory.createConsumer();
			kafkaConsumer.subscribe(Arrays.asList("catalog-request-topic"));

			// Consultar el mensaje en el tópico utilizando el consumidor Kafka
			Map<String, List<ClientCatalogEvent>> records = new HashMap<>();
			ConsumerRecords<String, ClientCatalogEvent> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
			consumerRecords
					.forEach(record -> records.computeIfAbsent(record.key(), k -> new ArrayList<>()).add(record.value())

					);
			System.out.println(" <<checkIfMessageExistsInTopic>> VERIFICANDO EN EL TOPICO: " + messageId);
			// Verificar si el mensaje con el UUID dado existe en los registros del tópico
			boolean messageExists = records.containsKey(messageId);

			// Cerrar el consumidor
			kafkaConsumer.close();
			System.out.println("<<checkIfMessageExistsInTopic>> EXISTE EL MENSAJE : " + messageExists);
			return messageExists;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
