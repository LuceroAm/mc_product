package com.nttdata.bootcamp.product.util;

import com.nttdata.bootcamp.product.model.Product;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;

public class ProductBuilder {

    public final static Product productRequestToProductEntity (ProductRequest request){
        return Product.builder()
                .id(request.getId())
                .productType(request.getProductType())
                .accountType(request.getAccountType())
                .creditType(request.getCreditType())
                .accountNumber(request.getAccountNumber())
                .build();
    }

    public static ProductResponse productEntityToProductResponse(Product model){
        return ProductResponse.builder()
                .id(model.getId())
                .productType(model.getProductType())
                .accountType(model.getAccountType())
                .creditType(model.getCreditType())
                .accountNumber(model.getAccountNumber())
                .build();
    }


}
