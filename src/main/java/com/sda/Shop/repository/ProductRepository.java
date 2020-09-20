package com.sda.Shop.repository;

import com.sda.Shop.domain.Product;
import com.sda.Shop.dto.UpdateProductDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    private AtomicLong idCounter = new AtomicLong(0);

    public Product save(Product product) {
        product.setId(idCounter.getAndIncrement());
        productList.add(product);
        return product;
    }

    public List<Product> getAll() {
        return productList;

    }

    public void deleteById(Long id) {

        productList.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .ifPresent(e -> productList.remove(e));
    }

    public Product findById(Long id) {
        return productList.stream().filter(e -> e.getId().equals(id)).findAny().orElseGet(null);

    }

    public Product editProduct(Long id, UpdateProductDto updateProductDto) {
        Product product = productList.stream().filter(e -> e.getId().equals(id)).findAny().orElseGet(null);
        product.setPrice(updateProductDto.getPrice());
        product.setDescription(updateProductDto.getDescription());
        product.setQuantity(updateProductDto.getQuantity());
        return product;
    }

    public List<Product> getProductByName(String name) {
        List<Product> product = productList.stream()
                .filter(e -> e.getName()
                        .toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
        return product;
    }
}
