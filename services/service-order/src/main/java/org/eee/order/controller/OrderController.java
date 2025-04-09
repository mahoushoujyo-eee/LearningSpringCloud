package org.eee.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.eee.order.entities.Order;
import org.eee.order.properties.OrderProperties;
import org.eee.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    @RequestMapping("/create")
    public Order create(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId)
    {
        log.info("orderProperties:{}", orderProperties);
        return orderService.createOrder(userId, productId);
    }
}
