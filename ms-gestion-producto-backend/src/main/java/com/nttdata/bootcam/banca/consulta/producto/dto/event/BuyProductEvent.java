package com.nttdata.bootcam.banca.consulta.producto.dto.event;

import lombok.Data;

@Data
public class BuyProductEvent {
	private String typeClient;
	private String typeProduct;
	private String idClient;
	private String idProduct;
	private int cantidad;
	private String mensaje;
}
