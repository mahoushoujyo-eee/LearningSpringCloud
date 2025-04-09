package org.eee.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

    private String timeout;

    private String autoConfig;
}
