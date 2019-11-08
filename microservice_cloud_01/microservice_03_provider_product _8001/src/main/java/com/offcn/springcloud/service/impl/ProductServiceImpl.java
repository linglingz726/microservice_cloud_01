package com.offcn.springcloud.service.impl;

import com.offcn.springcloud.mapper.ProductMapper;
import com.offcn.springcloud.entities.Product;
import com.offcn.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public boolean add(Product product) {
        return productMapper.addproduct(product);
    }

    @Override
    public Product get(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
