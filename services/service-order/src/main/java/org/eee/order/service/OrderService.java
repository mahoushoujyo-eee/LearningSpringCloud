package org.eee.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.eee.order.entities.Order;
import org.eee.order.feign.ProductFeignClient;
import org.eee.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class OrderService
{
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("org.eee.order.feign.ProductFeignClient")
    @Autowired
    private ProductFeignClient productFeignClient;


    //兜底回调blockHandler不能触发！为什么？
    @SentinelResource(value = "creatOrder", blockHandler = "createOrderFallback", fallback = "createOrderFallback")
    public Order createOrder(Long userId, Long productId)
    {
        System.out.println("userId:" + userId);
        System.out.println("productId:" + productId);
        Order order = new Order();
        order.setId(1L);
        order.setUserId(userId);
        order.setUserName("张三");
        order.setTotalAmount(new BigDecimal(100));
        order.setProductList(Arrays.asList(productFeignClient.getProductInfo(productId)));
        System.out.println("创建订单");
        return order;
    }

    public Order createOrderFallback(Long userId, Long productId, Throwable throwable)
    {
        System.out.println("blockHandlerCreateOrder");
        Order order = new Order();
        order.setId(1L);
        order.setUserId(userId);
        order.setUserName("错误的张三");
        order.setTotalAmount(new BigDecimal(100));
        System.out.println("创建订单");

        return order;
    }

    private Product getProductFromRemote(Long productId)
    {

        String url ="http://service-product/product/" + productId;

        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }
}
