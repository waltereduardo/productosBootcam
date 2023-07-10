package com.nttdata.bootcam.banca.consulta.producto.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcam.banca.consulta.producto.dto.Producto;
import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoPost;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductResource {

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping
	public Flux getAllProduct(Producto producto) {
		return productoRepository.findAll().map(this::fromProductoDaoToProductoDto);
	}

	@GetMapping("/{id}")
	public Mono<Producto> findProductById(@PathVariable String id) {
		return productoRepository.findById(id).map(this::fromProductoDaoToProductoDto);
	}

	@PostMapping
	public Mono<Producto> createProduct(@RequestBody ProductoPost productoPost) {
		 return productoRepository.save(this.fromProductoPostToProductoDto(productoPost))
	                .map(this::fromProductoDaoToProductoDto);
	}
	
	@PutMapping
	public Mono<ProductoDAO> modifyProduct(@RequestBody ProductoDAO producto) {
		 return productoRepository.findById(producto.getId()).flatMap(pr->{
			 pr.setId(producto.getId());
			 pr.setTypeProduct(producto.getTypeProduct());
			 pr.setDetTypeProduct(producto.getDetTypeProduct());
			 pr.setDescDetTypeProduct(producto.getDescDetTypeProduct());
			 return productoRepository.save(pr);
		 });
	}
	

	private Producto fromProductoDaoToProductoDto(ProductoDAO prodDao) {
		Producto produc = new Producto();
		produc.setId(prodDao.getId());
		produc.setTypeProduct(prodDao.getTypeProduct());
		produc.setDetTypeProduct(prodDao.getDetTypeProduct());
		produc.setDescDetTypeProduct(prodDao.getDescDetTypeProduct());
		return produc;
	}

	private ProductoDAO fromProductoPostToProductoDto(ProductoPost productoPost) {
		ProductoDAO produc = new ProductoDAO();
		produc.setTypeProduct(productoPost.getTypeProduct());
		produc.setDetTypeProduct(productoPost.getDetTypeProduct());
		produc.setDescDetTypeProduct(productoPost.getDescDetTypeProduct());
		return produc;
	}
}
