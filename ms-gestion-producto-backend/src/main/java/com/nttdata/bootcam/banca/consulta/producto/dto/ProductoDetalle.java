package com.nttdata.bootcam.banca.consulta.producto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductoDetalle extends ProductoDetallePost {

	@JsonProperty("identificador")
	private String id;
	private ProductoDetallePost productoDetallePost;
}
