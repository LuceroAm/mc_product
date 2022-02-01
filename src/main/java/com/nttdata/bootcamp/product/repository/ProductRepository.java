package com.nttdata.bootcamp.product.repository;

import com.nttdata.bootcamp.product.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>Class</b>: {@link ProductRepository}<br/>
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
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
