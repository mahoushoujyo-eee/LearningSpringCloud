package org.eee.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Token implements RequestInterceptor
{

    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        log.info("Interceptor:{}", "启动！");
        requestTemplate.header("token", "123456");
        requestTemplate.header("userId", "123456");
        requestTemplate.header("userName", "123456");
    }
}
