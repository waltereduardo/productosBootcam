package com.nttdata.bootcam.banca.consulta.producto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveMongoRepository<ProductoDAO, String>{
	Flux<ProductoDAO> findByTypeProduct(String typeProduct);
}
