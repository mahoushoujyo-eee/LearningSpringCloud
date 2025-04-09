package org.eee.order;

import lombok.extern.slf4j.Slf4j;
import org.eee.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.List;

@SpringBootTest
@Slf4j
public class DiscoveryTest
{
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @Test
    void discovery()
    {
        List<String> services = discoveryClient.getServices();

        System.out.println(services);
        services.forEach(service ->
        {
            discoveryClient.getInstances(service).forEach(instance ->
            {
                System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            });
        });
    }

    @Test
    void balanceTest()
    {
        ServiceInstance serviceProduct = loadBalancerClient.choose("service-product");
        log.info("Instance:{}", serviceProduct.getPort());
    }

    @Value("${order.timeout}")
    private String timeout;

    @Test
    void nacosConfigTest()
    {
        log.info("timeout:{}", timeout);
    }

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    void weatherTest()
    {
        String weather = weatherFeignClient.getWeather();
        System.out.println(weather);
    }
}
