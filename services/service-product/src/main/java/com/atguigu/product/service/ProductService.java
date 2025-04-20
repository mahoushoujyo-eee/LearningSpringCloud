package com.atguigu.product.service;


import org.eee.product.entities.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService
{

    public Product getProduct(Long productId) throws InterruptedException {
        System.out.println("查询商品信息");
        Product product = new Product();
        product.setId(productId);
        product.setNum(100);
        product.setPrice(new BigDecimal(100));
        product.setProductName("华为手机");
        //TimeUnit.SECONDS.sleep(1);
        return product;
    }
}
