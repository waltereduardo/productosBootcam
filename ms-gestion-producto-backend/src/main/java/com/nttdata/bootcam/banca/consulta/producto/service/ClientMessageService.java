package com.nttdata.bootcam.banca.consulta.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.mensajeria.repository.PedidoCatalogoRepository;
import com.nttdata.bootcam.banca.consulta.producto.mensajeria.repository.dao.SolicitudCatalogoDAO;

import reactor.core.publisher.Flux;

/**
 * Clase tipo service, para las validaciones de los mensajes
 * 
 * @author wrodrigr
 */
@Service
public class ClientMessageService {

	@Autowired
	private PedidoCatalogoRepository pedidoCatalogoRepository;

	public Flux<SolicitudCatalogoDAO> getIdMensaje(String typeMensaje) {

		return pedidoCatalogoRepository.findByTypeMensaje(typeMensaje);
	}
}
