package com.nttdata.bootcam.banca.consulta.producto.config;

import org.springframework.context.annotation.Configuration;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import java.time.Duration;


@Configuration
public class ResilienceConfig {

}
