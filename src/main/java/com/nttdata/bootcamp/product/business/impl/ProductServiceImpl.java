package com.nttdata.bootcamp.product.business.impl;

import com.nttdata.bootcamp.product.business.ProductService;
import com.nttdata.bootcamp.product.business.mapper.ProductMapper;
import com.nttdata.bootcamp.product.model.Product;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import com.nttdata.bootcamp.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * <b>Class</b>: {@link ProductServiceImpl}<br/>
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
@Service
@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
//    @Autowired
    private ProductRepository productRepository;

//    @Autowired
    private static final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public Mono<ProductResponse> create(ProductRequest productRequest) {
        log.info("Guardando datos del Producto");
        return productRepository.save(mapper.toEntity(productRequest))
                .map(mapper::toResponse);
//        return productRepository.save(setProduct(productRequest))
//                 .map(this::getProduct);
    }

    private Product setProduct (ProductRequest request){
        Product p = new Product();
        p.setAccountNumber(request.getAccountNumber());
        return p;
    }
    private ProductResponse getProduct (Product model){
        ProductResponse p = new ProductResponse();
        p.setAccountNumber(model.getAccountNumber());
        return p;
    }

    @Override
    public Mono<ProductResponse> findById(String id) {
        return null;
    }

    @Override
    public Flux<ProductResponse> findAll() {
        return null;
    }

    @Override
    public Mono<ProductResponse> update(ProductRequest productRequest) {
        return null;
    }

    @Override
    public Mono<ProductResponse> remove(String id) {
        return null;
    }
}
