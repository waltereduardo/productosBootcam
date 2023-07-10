package com.nttdata.bootcam.banca.consulta.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.dto.Producto;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

import reactor.core.publisher.Flux;

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
	
	
}
