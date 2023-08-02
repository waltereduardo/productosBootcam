package com.nttdata.bootcam.banca.consulta.producto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.nttdata.bootcam.banca.consulta.producto.mensajeria.repository", reactiveMongoTemplateRef = "mensajeriaReactiveMongoTemplate")
public class MensajeriaMongoConfig {

	@Value("${spring.data.mongodbkafka.uri}")
	private String mensajeriaMongoUri;

	@Bean
	public MongoClient mensajeriaMongoClient() {
		return MongoClients.create(mensajeriaMongoUri);
	}

	@Bean
	public ReactiveMongoTemplate mensajeriaReactiveMongoTemplate() {
		return new ReactiveMongoTemplate(mensajeriaMongoClient(), "mensajeria");
	}
}
