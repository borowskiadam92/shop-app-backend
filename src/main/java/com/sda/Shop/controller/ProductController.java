package com.sda.Shop.controller;

import com.sda.Shop.domain.Product;
import com.sda.Shop.dto.CreateProductDto;
import com.sda.Shop.dto.UpdateProductDto;
import com.sda.Shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody @Valid CreateProductDto dto) {
        Product p = service.save(dto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {

        List<Product> pa = service.getAll();
        return new ResponseEntity<>(pa, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable Long productId) {
        Product back = service.findById(productId);
        return back;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> editProduct(@PathVariable Long productId, @RequestBody UpdateProductDto dto) {
        Product back1 = service.editProduct(productId, dto);
        return new ResponseEntity<>(back1, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name) {
        List<Product> productByName = service.getProductByName(name);
        return new ResponseEntity<>(productByName, HttpStatus.FOUND);
    }
}
