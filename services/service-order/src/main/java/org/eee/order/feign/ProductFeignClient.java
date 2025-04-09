package org.eee.order.feign;

import org.eee.order.feign.fallback.ProductFeignClientFallback;
import org.eee.product.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient
{

    @GetMapping("/product/{id}")
    Product getProductInfo(@PathVariable("id") Long id);
}
