package com.nttdata.bootcam.banca.consulta.producto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import reactor.core.publisher.Flux;

public interface ProductoDetalleRepository extends ReactiveMongoRepository<ProductoDetalleDAO, String> {
	Flux<ProductoDetalleDAO> findByIdTypeProduct(String idTypeProduct);
}
