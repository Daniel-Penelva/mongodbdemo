package com.daniel.coding.mongodbdemo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        productService.delete(id);
        return ResponseEntity.accepted().build();

        /*
        * Este é o corpo do método. Ele cria uma instância de ResponseEntity com o status HTTP "202 Accepted". O código de status "202" indica que a
        * solicitação foi aceita para processamento, mas o processamento ainda não foi concluído. O método build() cria uma resposta sem corpo.*/
    }
}
