package com.nttdata.bootcam.banca.consulta.producto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;
import com.nttdata.bootcam.banca.consulta.producto.service.CatalogoService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ProductoDataCatalogoController {

	@Autowired
	private CatalogoService catalogoService;
	
	@GetMapping("/data-catalogo")
	public Flux<ProductoDetalleDAO> getDataCalogoProducto() {
		return catalogoService.getCatalogo();
	}
}
