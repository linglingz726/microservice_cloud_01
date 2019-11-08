package com.offcn.springcloud.mapper;

import com.offcn.springcloud.entities.Product;

import java.util.List;

public interface ProductMapper {
    boolean addproduct(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
