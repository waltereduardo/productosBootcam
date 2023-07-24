package com.nttdata.bootcam.banca.consulta.producto.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

import org.springframework.http.MediaType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HandlerProduct {

	@Autowired
	private ProductoRepository productoRepository;

	public Mono<ServerResponse> getProductAll(ServerRequest request) {
		Flux<ProductoDAO> productStream = productoRepository.findAll();
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(productStream, ProductoDAO.class);
	}

	public Mono<ServerResponse> findProductById(ServerRequest request) {
		int productId = Integer.valueOf(request.pathVariable("input"));
		Mono<ProductoDAO> productStream = productoRepository.findById(String.valueOf(productId));
		return ServerResponse.ok().body(productStream, ProductoDAO.class);
	}

	public Mono<ServerResponse> saveProduct(ServerRequest request) {
		Mono<ProductoDAO> productMono = request.bodyToMono(ProductoDAO.class);
		Mono<String> saveResponse = productMono.map(dto -> dto.getId() + ":" + dto.getTypeProduct()+":"+dto.getDescTypeProduct()+":"+dto.getDateCreate());
		return ServerResponse.ok().body(saveResponse, String.class);
	}
}