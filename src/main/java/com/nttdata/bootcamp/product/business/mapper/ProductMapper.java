package com.nttdata.bootcamp.product.business.mapper;

import com.nttdata.bootcamp.product.model.Product;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ProductMapper {

    @Mapping(source ="accountNumber" , target="accountNumber")
    Product toEntity (ProductRequest request);

    @Mapping(source ="accountNumber" , target="accountNumber")
    ProductResponse toResponse (Product model);
}
