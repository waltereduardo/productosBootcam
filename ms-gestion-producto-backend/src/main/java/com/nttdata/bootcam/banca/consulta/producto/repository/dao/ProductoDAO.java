package com.nttdata.bootcam.banca.consulta.producto.repository.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("producto-banco")
public class ProductoDAO {

	@Id
	private String id;
	private String typeProduct;
	private String descTypeProduct;
	private String dateCreate;
	private String state;

}
