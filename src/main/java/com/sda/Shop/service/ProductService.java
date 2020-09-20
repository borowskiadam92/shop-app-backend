package com.sda.Shop.service;

import com.sda.Shop.domain.Product;
import com.sda.Shop.dto.CreateProductDto;
import com.sda.Shop.dto.UpdateProductDto;
import com.sda.Shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public Product save(CreateProductDto dto) {
        Product product = Product.builder()
                .category(dto.getCategory())
                .description(dto.getDescription())
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .creationTime(LocalDateTime.now())
                .build();
        repository.save(product);
        return product;
    }

    public List<Product> getAll() {
        return repository.getAll();

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

    public Product editProduct(Long id, UpdateProductDto updateProductDto) {
        return repository.editProduct(id, updateProductDto);

    }

    public List<Product> getProductByName(String name) {
        return repository.getProductByName(name);

    }

}
