package org.eee.order.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order
{
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String userName;
    private List<Object> productList;
}
