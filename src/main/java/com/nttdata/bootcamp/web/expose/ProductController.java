package com.nttdata.bootcamp.web.expose;

import com.nttdata.bootcamp.product.business.ProductService;
import com.nttdata.bootcamp.product.model.dto.request.ProductRequest;
import com.nttdata.bootcamp.product.model.dto.response.ProductResponse;
import com.nttdata.bootcamp.product.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservicio Product", description = "Esta API se encarga de la gestion de los Productos")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Mono<ProductResponse> create(@RequestBody ProductRequest request) {
        log.info("Metoth Create product");
        return productService.create(request);
    }

  @GetMapping
  @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
  public Flux<ProductResponse> findAll() {
    log.info("Metoth findAll ");
    return productService.findAll();
  }

}
