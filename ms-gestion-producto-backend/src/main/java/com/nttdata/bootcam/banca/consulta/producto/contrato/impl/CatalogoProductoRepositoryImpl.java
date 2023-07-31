package com.nttdata.bootcam.banca.consulta.producto.contrato.impl;

import java.util.function.Function;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.ReactiveFluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcam.banca.consulta.producto.contrato.CatalogoProductoRepository;
import com.nttdata.bootcam.banca.consulta.producto.repository.dao.ProductoDetalleDAO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CatalogoProductoRepositoryImpl implements CatalogoProductoRepository {

	@Override
	public <S extends ProductoDetalleDAO> Mono<S> insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> insert(Publisher<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Mono<S> save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Flux<S> saveAll(Publisher<S> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ProductoDetalleDAO> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ProductoDetalleDAO> findById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<ProductoDetalleDAO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<ProductoDetalleDAO> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<ProductoDetalleDAO> findAllById(Publisher<String> idStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(ProductoDetalleDAO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Iterable<? extends ProductoDetalleDAO> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Publisher<? extends ProductoDetalleDAO> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<ProductoDetalleDAO> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Mono<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Mono<Long> count(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO> Mono<Boolean> exists(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductoDetalleDAO, R, P extends Publisher<R>> P findBy(Example<S> example,
			Function<ReactiveFluentQuery<S>, P> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
