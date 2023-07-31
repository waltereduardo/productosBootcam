package com.nttdata.bootcam.banca.consulta.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.contrato.CatalogoProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.contrato.impl.CatalogoProductoRepositoryImpl;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import reactor.core.publisher.Flux;


@Service
public class CatalogoService {

	@Autowired
	private CatalogoProductoRepository catalogoProductoRepository;//////////////////////
	
	
	private Flux<ProductoDetalleDAO> catalogo;
	
	// Método para llenar el catálogo de productos
    public void fillCatalogo() {
        catalogo = findAll();
    }
    
    // Método para obtener el catálogo de productos (ya lleno)
    public Flux<ProductoDetalleDAO> getCatalogo() {
        return catalogo;
    }
/**
 * Al mostrar el catalogo de producto, puede fallar.
 * Envolvemos el metodo con el patron circuit breaker
 * @author wrodrigr
 * @return
 */
    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackAccounts")
    @Retry(name = "accountService", fallbackMethod = "fallbackAccounts")
	public Flux<ProductoDetalleDAO> findAll() {
		return catalogoProductoRepository.findAll();
	}



}
