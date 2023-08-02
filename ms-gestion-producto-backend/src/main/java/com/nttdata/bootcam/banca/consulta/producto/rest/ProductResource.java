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
import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoDetalle;
import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoDetallePost;
import com.nttdata.bootcam.banca.consulta.producto.dto.ProductoPost;
import com.nttdata.bootcam.banca.consulta.producto.repository.PedidoCatalogoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.ProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDAO;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;
import com.nttdata.bootcam.banca.consulta.producto.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductResource {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private PedidoCatalogoRepository pedidoCatalogoRepository;

	// 1. start of CRUD
	@GetMapping
	public Flux getAllProduct(Producto producto) {
		return productoService.getProductAll().map(this::fromProductoDaoToProductoDto);
	}

	@GetMapping("/{id}")
	public Mono<Producto> findProductById(@PathVariable String id) {
		return productoService.findById(id).map(this::fromProductoDaoToProductoDto);
	}

	@PostMapping
	public Mono<Producto> createProduct(@RequestBody ProductoPost productoPost) {
		return productoRepository.save(this.fromProductoPostToProductoDto(productoPost))
				.map(this::fromProductoDaoToProductoDto);
	}

	@PutMapping
	public Mono<ProductoDAO> modifyProduct(@RequestBody ProductoDAO producto) {
		return productoRepository.findById(producto.getId()).flatMap(pr -> {
			pr.setId(producto.getId());
			pr.setTypeProduct(producto.getTypeProduct());
			pr.setDescTypeProduct(producto.getDescTypeProduct());
			pr.setDateCreate(producto.getDateCreate());
			pr.setState(producto.getState());
			return productoRepository.save(pr);
		});
	}
	// 2. productos por tipo de producto del banco

	@GetMapping("typeProduct/{typeProducto}")
	public Flux getAllTypeProduct(@PathVariable String typeProducto) {
		return productoService.findTypeProductoByType(typeProducto).map(this::fromProductoDaoToProductoDto);
	}

	// 3. Detalle del tipo de producto
	@GetMapping("detalleProduct/{typeProducto}")
	public Flux getAllDetalleProduct(@PathVariable String typeProducto) {
		return productoService.findDetalleTypeProducto(typeProducto).map(this::fromProductoDetalleDaoToProductoDto);
	}

	private Producto fromProductoDaoToProductoDto(ProductoDAO prodDao) {
		Producto produc = new Producto();
		ProductoPost proPost = new ProductoPost();
		System.out.println("-----------" + prodDao);
		produc.setTypeProduct(prodDao.getTypeProduct());
		produc.setDescTypeProduct(prodDao.getDescTypeProduct());
		produc.setDateCreate(prodDao.getDateCreate());
		if ("1".equals(prodDao.getState())) {
			produc.setState("ACTIVO");
		} else {
			produc.setState("INACTIVO");
		}
//		produc.setProductoPost(proPost);
		produc.setId(prodDao.getId());
		return produc;
	}

	private ProductoDetalle fromProductoDetalleDaoToProductoDto(ProductoDetalleDAO prodDao) {
		ProductoDetalle produc = new ProductoDetalle();
		ProductoDetallePost prodPost = new ProductoDetallePost();
		if ("1".equals(prodDao.getIdTypeProduct())) {
			prodPost.setIdTypeProduct(prodDao.getIdTypeProduct());
			produc.setDescCortaProduct("PASIVOS - CUENTAS BANCARIAS");
		} else {
			prodPost.setIdTypeProduct(prodDao.getIdTypeProduct());
			produc.setDescCortaProduct("ACTIVOS - CREDITOS");
		}
		prodPost.setDescCortaProduct(prodDao.getDescCortaProduct());
		prodPost.setDesLargaProducto(prodDao.getDesLargaProducto());
		if ("1".equals(prodDao.getState())) {
			prodPost.setState("ACTIVO");
		} else {
			prodPost.setState("INACTIVO");
		}
		produc.setProductoDetallePost(prodPost);
		produc.setId(prodDao.getId());
		return produc;
	}

	private ProductoDAO fromProductoPostToProductoDto(ProductoPost productoPost) {
		ProductoDAO produc = new ProductoDAO();
//		produc.setId(productoPost.get);
		produc.setTypeProduct(productoPost.getTypeProduct());
		produc.setDescTypeProduct(productoPost.getDescTypeProduct());
		produc.setDateCreate(productoPost.getDateCreate());
		produc.setState(productoPost.getState());
		return produc;
	}
}
