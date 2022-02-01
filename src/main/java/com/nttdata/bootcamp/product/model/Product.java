package com.nttdata.bootcamp.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * <b>Class</b>: {@link Product}<br/>
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
@Document(collection = "product")
@Builder
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();
    private ProductType productType;
    private AccountType accountType;
    private CreditType creditType;
    private String accountNumber;
}
