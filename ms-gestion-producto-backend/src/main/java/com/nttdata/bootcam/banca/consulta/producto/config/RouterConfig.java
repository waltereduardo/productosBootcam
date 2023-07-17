package com.nttdata.bootcam.banca.consulta.producto.config;

import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoPost;
import com.nttdata.bootcam.banca.consulta.producto.handler.HandlerProduct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;


@Configuration
public class RouterConfig {

	@Autowired
	private HandlerProduct handlerProduct;

	@RouterOperations({ 
		@RouterOperation(path = "/router/product", 
				produces = {
							MediaType.APPLICATION_JSON_VALUE }, 
							method = RequestMethod.GET, 
							beanClass = HandlerProduct.class, 
							beanMethod = "getProductAll", 
							operation = @Operation(
									operationId = "getProductAll", 
									responses = {
												@ApiResponse(
														responseCode = "200", 
														description = "successful operation", 
														content = @Content(
																schema = @Schema(
																		implementation = ProductoPost.class)
																)
														) 
												}
									)
		),
        @RouterOperation(
                path = "/router/product/{input}",
                produces = {
                        MediaType.APPLICATION_JSON_VALUE
                },
                method = RequestMethod.GET,
                beanClass = HandlerProduct.class,
                beanMethod = "findProduct",
                operation = @Operation(
                        operationId = "findProduct",
                        responses = {
                                @ApiResponse(
                                        responseCode = "200",
                                        description = "successful operation",
                                        content = @Content(schema = @Schema(
                                                implementation = ProductoPost.class
                                        ))
                                ),
                                @ApiResponse(responseCode = "404", description = "product not found with" +
                                        " given id")
                        },
                        parameters = {
                                @Parameter(in = ParameterIn.PATH, name = "input")
                        }

                )

        ),
        @RouterOperation(
                path = "/router/product",
                produces = {
                        MediaType.APPLICATION_JSON_VALUE
                },
                method = RequestMethod.POST,
                beanClass = HandlerProduct.class,
                beanMethod = "saveProduct",
                operation = @Operation(
                        operationId = "saveProduct",
                        responses = {
                                @ApiResponse(
                                        responseCode = "200",
                                        description = "successful operation",
                                        content = @Content(schema = @Schema(
                                                implementation = String.class
                                        ))
                                )
                        },
                        requestBody = @RequestBody(
                                content = @Content(schema = @Schema(
                                        implementation = ProductoPost.class
                                ))
                        )

                )


        )
		
		})
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
				.GET("", handlerProduct::getProductAll)
				.GET("/router/product/{input}", handlerProduct::findProductById)
				.POST("/router/product", handlerProduct::saveProduct)
				.build();
	}

}
