package com.atguigu.business.service.impl;

import com.atguigu.business.feign.OrderFeignClient;
import com.atguigu.business.feign.StorageFeignClient;
import com.atguigu.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    StorageFeignClient storageFeignClient;

    @Autowired
    OrderFeignClient orderFeignClient;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        //TODO 1. 扣减库存

        storageFeignClient.deduct(commodityCode, orderCount);

        //TODO 2. 创建订单
        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
