package org.eee.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.eee.order.entities.Order;
import org.eee.order.properties.OrderProperties;
import org.eee.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @SentinelResource(value = "sec-kill-order", fallback = "secKillFallback")
    @RequestMapping("/sec-kill")
    public Order secKill(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId)
    {
        log.info("orderProperties:{}", orderProperties);
        Order order = orderService.createOrder(userId, productId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    public Order secKillFallback(Long userId, Long productId, Throwable throwable)
    {
        Order order = new Order();
        order.setId(Long.MAX_VALUE);
        order.setUserId(userId);
        order.setUserName("兜底错误secKill");
        return order;
    }

    @GetMapping("/write")
    public String write()
    {
        return "write!";
    }

    @GetMapping("/read")
    public String read()
    {
        return "read!";
    }
}
