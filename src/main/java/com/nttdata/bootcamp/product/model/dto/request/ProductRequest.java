package com.nttdata.bootcamp.product.model.dto.request;

import com.nttdata.bootcamp.product.model.AccountType;
import com.nttdata.bootcamp.product.model.CreditType;
import com.nttdata.bootcamp.product.model.ProductType;
import com.nttdata.bootcamp.product.model.TypeDocument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * <b>Class</b>: {@link ProductRequest}<br/>
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Model ProductRequest")
@Builder
public class ProductRequest {
    @ApiModelProperty(value = "id", position = 1)
    private String id = UUID.randomUUID().toString();

    @ApiModelProperty(value = "productType", position = 2)
    private ProductType productType;

    @ApiModelProperty(value = "accountType", position = 3)
    private AccountType accountType;

    @ApiModelProperty(value = "creditType", position = 4)
    private CreditType creditType;

    @ApiModelProperty(value = "accountNumber", position = 5)
    private String accountNumber;

    @ApiModelProperty(value = "typeDocument", position = 6)
    private TypeDocument typeDocument;

    @ApiModelProperty(value = "numberDocument", position = 7)
    private String numberDocument;

    @ApiModelProperty(value = "cardNumber", position = 8)
    private String cardNumber;

    @ApiModelProperty(value = "password", position = 9)
    private String password;

    @ApiModelProperty(value = "amount", position = 10)
    private String amount;
}
