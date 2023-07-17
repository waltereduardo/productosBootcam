package com.nttdata.bootcam.banca.consulta.producto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
//@RequiredArgsConstructor
public class ProductoService {

	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository produRepository) {
		this.productoRepository=produRepository;
	}
	
//	public Flux listAllProd() {
//		return productoRepository.findAll().map(this::fromProducto);
//	}
	

	
	public Flux<ProductoDAO>  getProductAll() {
		return productoRepository.findAll();
	};
	
	public Mono<ProductoDAO> findById(String id) {
		return productoRepository.findById(id);
	}
	
	
}
