package org.eee.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//url优先级高于value
@FeignClient(value = "weather-client", url = "https://helloworld.openeee.cn")
public interface WeatherFeignClient
{
    @GetMapping("/")
    String getWeather();
}
