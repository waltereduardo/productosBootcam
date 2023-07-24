package com.nttdata.bootcam.banca.consulta.producto.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoCatalogoKafka;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoDetalleRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import reactor.core.publisher.Flux;

@Service
public class KafkaConsumerService {

	@Autowired
	private ProductoDetalleRepository productoDetalleRepository;
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
//	@KafkaListener(topics = "my-topic")
//	public void receiveMessage(String message) {
//		System.out.println("Received message: " + message);
//	}
//
//	@KafkaListener(topics = "catalog-request-topic")
//	public void receiveCatalogRequest(String message) {
//		System.out.println("2. HAY UN PEDIDO DE CATALOGO --------------------" + message);
//	    Flux<ProductoDetalleDAO> dt= productoDetalleRepository.findAll();
//
//	    dt.subscribe(productoDetalleDAO->{
//		    System.out.println(" los productos ::  "   + productoDetalleDAO);
//		    ProductoCatalogoKafka pk=new ProductoCatalogoKafka();
//		    pk.setId(productoDetalleDAO.getId());
//		    pk.setIdTypeProduct(productoDetalleDAO.getIdTypeProduct());
//		    pk.setDescCortaProduct(productoDetalleDAO.getDescCortaProduct());
//		    pk.setCantidad(productoDetalleDAO.getCantidad());
//		    pk.setPrecioUnitario(productoDetalleDAO.getPrecioUnitario());
////		    kafkaProducerService.sendCatalog(pk);
//	    });
////	    
//	}
//
//	private ProductoCatalogoKafka obtenerCatalogoDeProductos() {
//		ProductoCatalogoKafka catalog = new ProductoCatalogoKafka();
//		Flux<ProductoDetalleDAO> pddao = productoDetalleRepository.findAll();
//		ProductoDetalleDAO productoDetalle = pddao.blockFirst();
//		catalog.setId(productoDetalle.getId());
//		catalog.setIdTypeProduct(productoDetalle.getIdTypeProduct());
//		catalog.setPrecioUnitario(productoDetalle.getPrecioUnitario());
//		catalog.setCantidad(productoDetalle.getCantidad());
//		catalog.setDescCortaProduct(productoDetalle.getDescCortaProduct());
//		return catalog;
//	}

}
