package com.nttdata.bootcam.banca.consulta.producto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

public interface ProductoRepository extends ReactiveMongoRepository<ProductoDAO, String>{

}
