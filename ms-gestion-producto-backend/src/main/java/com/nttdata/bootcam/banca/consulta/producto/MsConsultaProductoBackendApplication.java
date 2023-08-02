package com.nttdata.bootcam.banca.consulta.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@ComponentScan("com.nttdata.bootcam.banca.consulta.producto")
@EnableOpenApi
@OpenAPIDefinition(info = @Info(title = "REST  DEFINITION, ms-gestion-product-backend", version = "1.0.0", description = "Micro  service product management"))
public class MsConsultaProductoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsultaProductoBackendApplication.class, args);
	}

}
