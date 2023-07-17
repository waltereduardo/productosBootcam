package com.nttdata.bootcam.banca.consulta.producto.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TestProductoService {
	
	@Mock
	private ProductoRepository productoRepository;

	@InjectMocks
	private ProductoService productoService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetProductAll() {
		ProductoDAO produc1 = new ProductoDAO();
		produc1.setId("1");
		produc1.setTypeProduct("1");
		produc1.setDetTypeProduct("2");
		produc1.setDescDetTypeProduct("cuenta corriente");

		ProductoDAO product2 = new ProductoDAO();
		product2.setId("1");
		product2.setTypeProduct("2");
		product2.setDetTypeProduct("2");
		product2.setDescDetTypeProduct("plazo fijo");

		when(productoRepository.findAll()).thenReturn(Flux.just(produc1, product2));

		Flux<ProductoDAO> result = productoService.getProductAll();

		StepVerifier
			.create(result)
			.expectNext(produc1)
			.expectNext(product2)
			.verifyComplete();
	}

    @Test
    public void testFindById() {
        String productId = "1";
        ProductoDAO product = new ProductoDAO();
        product.setId("1");
        product.setTypeProduct("2");
        product.setDetTypeProduct("2");
        product.setDescDetTypeProduct("plazo fijo");

        when(productoRepository.findById(anyString())).thenReturn(Mono.just(product));

        Mono<ProductoDAO> result = productoService.findById(productId);

        StepVerifier.create(result)
                .expectNext(product)
                .verifyComplete();
    }
	
}
