package com.offcn.springcloud.controller;

import com.offcn.springcloud.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ProductController_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //负载均衡
        // 将http后面写为大写的 8001下的（提供者yml配置文件Spring： name的值）microservice-product
    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PRODUCT";

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/product/add")
    public boolean add(Product product){
        return restTemplate.postForObject(REST_URL_PREFIX+"/product/add",product,Boolean.class);
    }
    @RequestMapping("/consumer/product/get/{pid}")
    public Product get(@PathVariable("pid") Long pid){
       Product product = (Product)restTemplate.getForObject(REST_URL_PREFIX+"/product/get/"+pid,Product.class);
       return product;
    }
    @RequestMapping("/consumer/product/get/list")
    public List<Product> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/product/get/list",List.class);

    }


}
