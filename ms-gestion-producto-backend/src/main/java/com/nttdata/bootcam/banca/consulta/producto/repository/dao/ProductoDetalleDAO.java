package com.nttdata.bootcam.banca.consulta.producto.repository.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("producto-banco-detalle")
public class ProductoDetalleDAO {

	@Id
	private String id;
	private String idTypeProduct;
	private String descCortaProduct;
	private String desLargaProducto;
	private String state;
	private String cantidad;
	private String precioUnitario;
}
