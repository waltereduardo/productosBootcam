package com.nttdata.bootcam.banca.consulta.producto.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.ClientCreatedEvent;
import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.ClientCreatedEventCompra;
import com.nttdata.bootcam.banca.consulta.client.infraestructure.event.Event;
import com.nttdata.bootcam.banca.consulta.producto.service.CatalogoService;
import com.nttdata.bootcam.banca.consulta.producto.service.ClientMessageService;
import com.nttdata.bootcam.banca.consulta.producto.util.Constantes;

/**
 * Clase escuchadora de mensajes
 * 
 * @author wrodrigr
 */

@Component
public class ClientEventsService {

	@Autowired
	private CatalogoService catalogoService;

	@Autowired
	private ClientMessageService clientMessageService;
	@Autowired
	private ClientMessageCatalogService clientMessageCatalogService;

	@KafkaListener(topics = "catalog-request-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "my-group")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(ClientCreatedEvent.class)) {
			ClientCreatedEvent clientCreatedEvent = (ClientCreatedEvent) event;
			System.out.println("<<consumer>> Received CLIENT CREATED EVENT" + "//" + clientCreatedEvent + "///"
					+ clientCreatedEvent.getId() + "//" + clientCreatedEvent.getData().getId() + "//"
					+ clientCreatedEvent.getData().getMensaje() + "//" + clientCreatedEvent.getData().getNameAll());

			if (Constantes.MSG_CATALOGO.equals(clientCreatedEvent.getData().getMensaje())) {
				// 1. LLenar el catalogo de productos
				catalogoService.fillCatalogo();
			} else {
				System.out.println("NO HAY NADA----------------");
			}

//			clientMessageService.getIdMensaje(clientCreatedEvent.getData().getMensaje().toUpperCase())
//			.collectList()
//					.subscribe(result -> {
//						System.out.println("RESULTADO DE LA BUSQUEDA POR TIPO DE MENSAJE" +result);
//						if (!result.isEmpty()) {
//							System.out.println("Cantidad de mensajes : " + result.size());
//							SolicitudCatalogoDAO lastMessage = result.get(result.size() - 1);
//							String lastIdMessage = lastMessage.getIdMensaje();
//							System.out.println("Ultimo mensaje : " + lastIdMessage);
//							if (clientMessageCatalogService.checkIfMessageExistsInTopic(lastIdMessage)) {
//								System.out.println("--------ENCONTRADO----------------");
//							} else {
//								System.out.println("NO HAY NADA----------------");
//								// 1. LLenar el catalogo de productos
//								catalogoService.fillCatalogo();
//							}
//
//						} else {
//							System.out.println("No hay mensajes en el topico.");
//						}
//					}, error -> {
//						System.out.println("ERROR : " + error.getMessage());
//					});

		}

	}

	@KafkaListener(topics = "order-request-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "my-group")
	public void consumerOrder(Event<?> event) {
		if (event.getClass().isAssignableFrom(ClientCreatedEventCompra.class)) {
			ClientCreatedEventCompra clientCreatedEventCompra = (ClientCreatedEventCompra) event;
			System.out.println(" <<consumerOrder>>  Received LA ORDEN .... with Id={}, data={}" + "//" + clientCreatedEventCompra.getId()
					+ "//" + clientCreatedEventCompra.getData().toString());
			if (Constantes.MSG_COMPRA.equals(clientCreatedEventCompra.getData().getMensaje())) {
				System.out.println("HAY ORDEN DE COMPRA----------------");
//				// 1. Realizar las validaciones. Establecer contrato con transacciones
//				catalogoService.fillCatalogo();
			} else {
				System.out.println("NO HAY NADA----------------");
			}

		}

	}

}
