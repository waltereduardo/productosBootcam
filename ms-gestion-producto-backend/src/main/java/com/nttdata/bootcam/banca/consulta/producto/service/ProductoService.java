package com.nttdata.bootcam.banca.consulta.producto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoDetalleRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
//@RequiredArgsConstructor
public class ProductoService {

	private final ProductoRepository productoRepository;
	private final ProductoDetalleRepository productoDetalleRepository;
	
	@Autowired
	public ProductoService(ProductoRepository produRepository,ProductoDetalleRepository productoDetalleRepository) {
		this.productoRepository=produRepository;
		this.productoDetalleRepository=productoDetalleRepository;
	}
	
//	@Autowired
//	public ProductoService(ProductoDetalleRepository productoDetalleRepository) {
//		this.productoDetalleRepository=productoDetalleRepository;
//	}
//	
//	public Flux listAllProd() {
//		return productoRepository.findAll().map(this::fromProducto);
//	}
	
	public Flux<ProductoDAO>  getProductAll() {
		return productoRepository.findAll();
	};
	
	public Mono<ProductoDAO> findById(String id) {
		return productoRepository.findById(id);
	}
	
	public Flux<ProductoDAO> findTypeProductoByType(String typeProducto){
		return productoRepository.findByTypeProduct(typeProducto);
	}
	
	public Flux<ProductoDetalleDAO> findDetalleTypeProducto(String typeProducto){
		return productoDetalleRepository.findByIdTypeProduct(typeProducto);
	}
}
