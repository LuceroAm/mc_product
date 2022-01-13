package com.nttdata.bootcamp.product.business;

import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: {@link ProductService}<br/>
 * @author NTTDATA <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>L.A.T.</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>06/01/2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
public interface ProductService {
    Mono<ProductResponse> create(ProductRequest productRequest);

    Mono<ProductResponse> findById(String id);

    Flux<ProductResponse> findAll();

    Mono<ProductResponse> update(ProductRequest productRequest);

    Mono<ProductResponse> remove(String id);
}
