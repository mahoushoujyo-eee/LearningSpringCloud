package org.eee.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GateWayMainApplication
{
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(GateWayMainApplication.class, args);
    }
}
