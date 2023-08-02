package com.nttdata.bootcam.banca.consulta.producto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

/**
 * Contrato entre el Consumidor y el RestController para exposicion del catalogo
 * de productos
 */
public interface CatalogoProductoRepository extends ReactiveMongoRepository<ProductoDetalleDAO, String> {

}
