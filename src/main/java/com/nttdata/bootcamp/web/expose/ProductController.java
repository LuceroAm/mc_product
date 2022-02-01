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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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

  @GetMapping(Constants.ID)
  @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
  public Mono<ProductResponse> findById(@PathVariable("id") String id) {
    log.info("Metoth findById ");
    return productService.findById(id);
  }

  @PutMapping(Constants.ID)
  @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
  public Mono<ResponseEntity<ProductResponse>> Update(@RequestBody ProductRequest request) {
    log.info("Metoth update ");
    return productService.update(request)
            .flatMap(productResponse -> Mono.just(ResponseEntity.ok(productResponse)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping(Constants.ID)
  @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
  public Mono<ResponseEntity<ProductResponse>> deletebyId(@PathVariable("id") String id) {
    log.info("Metoth deletebyId ");
    return productService.remove(id)
            .flatMap(productResponse -> Mono.just(ResponseEntity.ok(productResponse)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

    @GetMapping(Constants.GETFILTER)
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public Mono<ProductResponse> getData(@RequestParam Map<String, String> params){
        log.info("Metoth getData ");
        return productService.getData(params);
    }

}
