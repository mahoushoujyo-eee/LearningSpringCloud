package org.eee.order.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.eee.order.feign.ProductFeignClient;
import org.eee.product.entities.Product;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductFeignClientFallback implements ProductFeignClient
{

    @Override
    public Product getProductInfo(Long id)
    {
        log.info("ProductFeignClientFallback:{}", "降级！");
        return null;
    }
}
