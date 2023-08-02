package com.nttdata.bootcam.banca.consulta.producto.dto;

import lombok.Data;

@Data
public class ProductoCatalogoKafka {
	/**
	 * 
	 */
	private String id;
	private String idTypeProduct;
	private String descCortaProduct;
	private String cantidad;
	private String precioUnitario;
}
