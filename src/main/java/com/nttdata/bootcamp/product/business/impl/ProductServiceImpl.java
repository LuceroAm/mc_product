package com.nttdata.bootcamp.product.business.impl;

import com.nttdata.bootcamp.product.business.ProductService;
import com.nttdata.bootcamp.product.model.Product;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import com.nttdata.bootcamp.product.repository.ProductRepository;
import com.nttdata.bootcamp.product.util.ProductBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<ProductResponse> create(ProductRequest productRequest) {
        log.info("Guardar datos del Producto");
        return productRepository.save(setProduct(productRequest))
                 .map(this::getProduct);
//                 .map(product -> ProductBuilder
//                         .productEntityToProductResponse(product));
    }

    private Product setProduct (ProductRequest request){
        return Product.builder()
                .id(request.getId())
                .productType(request.getProductType())
                .accountType(request.getAccountType())
                .creditType(request.getCreditType())
                .accountNumber(request.getAccountNumber())
                .typeDocument(request.getTypeDocument())
                .numberDocument(request.getNumberDocument())
                .cardNumber(request.getCardNumber())
                .password(request.getPassword())
                .amount(request.getAmount())
                .build();
    }

    private ProductResponse getProduct (Product model){
        return ProductResponse.builder()
                .productType(model.getProductType())
                .accountType(model.getAccountType())
                .creditType(model.getCreditType())
                .accountNumber(model.getAccountNumber())
                .typeDocument(model.getTypeDocument())
                .numberDocument(model.getNumberDocument())
                .cardNumber(model.getCardNumber())
                .password(model.getPassword())
                .amount(model.getAmount())
                .build();
    }

    @Override
    public Mono<ProductResponse> findById(String id) {
        return productRepository.findById(id)
                .map(this::getProduct);
    }

    @Override
    public Flux<ProductResponse> findAll() {
        log.info("Obtener todos los registros de Productos");
        return productRepository.findAll()
                .map(this::getProduct);
    }

    @Override
    public Mono<ProductResponse> update(ProductRequest productRequest) {
        log.info("Actualizar un registro de un Producto");
        return productRepository.findById(productRequest.getId())
            .flatMap(customerDB -> {
          return create(productRequest);
            })
            .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProductResponse> remove(String id) {
        log.info("Eliminar un registro de un Producto");
        return productRepository
                .findById(id)
                .map(this::getProduct)
                .flatMap(productResponse ->  productRepository.deleteById(productResponse.getId())
                .thenReturn(productResponse));
    }
}
