package com.nttdata.bootcamp.product.util;

import com.nttdata.bootcamp.product.model.Product;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductBuilder {

    public final static Product productRequestToProductEntity (ProductRequest request){
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

    public static ProductResponse productEntityToProductResponse(Product model){
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


}
