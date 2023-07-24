package com.nttdata.bootcam.banca.consulta.producto.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoCatalogoKafka;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoDetalleRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import reactor.core.publisher.Flux;

@Service
public class KafkaProducerService {

//	private final KafkaTemplate<String, ProductoCatalogoKafka> kafkaTemplate;
//	private final ProductoDetalleRepository productoDetalleRepository;

//	@Autowired
//	public KafkaProducerService(KafkaTemplate<String, ProductoCatalogoKafka> kafkaTemplate) {
//		this.kafkaTemplate = kafkaTemplate;
////		this.productoDetalleRepository = productoDetalleRepository;
//	}
	
//    public void sendCatalog(ProductoCatalogoKafka catalog) {
//        System.out.println(" 3 . Enviando el catálogo --------------------" + catalog);
//        kafkaTemplate.send("catalog-topic", catalog);
//    }


	

}
