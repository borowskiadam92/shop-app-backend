package com.sda.Shop.service;

import com.sda.Shop.domain.Product;
import com.sda.Shop.dto.CreateProductDto;
import com.sda.Shop.dto.UpdateProductDto;
import com.sda.Shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Scope(value = "prototype")
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
        return repository.findAll();

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Product findById(Long id) {
        return repository.getOne(id);
    }

    public Product editProduct(Long id, UpdateProductDto updateProductDto) {
        Product product = repository.getOne(id);
        product.setPrice(updateProductDto.getPrice());
        product.setQuantity(updateProductDto.getQuantity());
        product.setDescription(updateProductDto.getDescription());
        return repository.save(product);

    }

    public List<Product> getProductByName(String name) {


    }

}
