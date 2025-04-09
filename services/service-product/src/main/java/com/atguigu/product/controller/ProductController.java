package com.atguigu.product.controller;


import com.atguigu.product.service.ProductService;
import org.eee.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId)
    {
        System.out.println("product");
        return productService.getProduct(productId);
    }
}
