package com.nttdata.bootcam.banca.consulta.producto.dto;

import lombok.Data;

@Data
public class ProductoDetallePost {

	private String idTypeProduct;
	private String descCortaProduct;
	private String desLargaProducto;
	private String state;
	private String cantidad;
	private String precioUnitario;

}
