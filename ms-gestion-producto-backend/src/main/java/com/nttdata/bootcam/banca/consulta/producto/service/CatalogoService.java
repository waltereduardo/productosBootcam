package com.nttdata.bootcam.banca.consulta.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.repository.CatalogoProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import reactor.core.publisher.Flux;

@Service
public class CatalogoService {

//	@Autowired
//	private CatalogoProductoRepository catalogoProductoRepository;//////////////////////

	private final CatalogoProductoRepository catalogoProductoRepository;

	@Autowired
	public CatalogoService(CatalogoProductoRepository catalogoProductoRepository) {
		this.catalogoProductoRepository = catalogoProductoRepository;
	}

	private Flux<ProductoDetalleDAO> catalogo;

	// Método para llenar el catálogo de productos
	public void fillCatalogo() {
		System.out.println("cccccccccccc");
		catalogo = findAll();
	}

	// Método para obtener el catálogo de productos (ya lleno)
	public Flux<ProductoDetalleDAO> getCatalogo() {
		System.out.println("bbbbbbbbbbb");
		return catalogo;
	}

	/**
	 * Al mostrar el catalogo de producto, puede fallar. Envolvemos el metodo con el
	 * patron circuit breaker
	 * 
	 * @author wrodrigr
	 * @return
	 */
//    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackAccounts")
//    @Retry(name = "accountService", fallbackMethod = "fallbackAccounts")
	public Flux<ProductoDetalleDAO> findAll() {

		return catalogoProductoRepository.findAll();
	}

}
