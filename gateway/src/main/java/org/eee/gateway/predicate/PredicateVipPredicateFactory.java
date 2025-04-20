package org.eee.gateway.predicate;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateVipPredicateFactory extends AbstractRoutePredicateFactory<PredicateVipPredicateFactory.Config>
{

    public PredicateVipPredicateFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }

    @Override
    public Predicate<ServerWebExchange> apply(Consumer consumer) {
        return super.apply(consumer);
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Consumer consumer) {
        return super.applyAsync(consumer);
    }

    @Override
    public void beforeApply(Config config) {
        super.beforeApply(config);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return null;
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Config config) {
        return super.applyAsync(config);
    }

    @Override
    public String name() {
        return super.name();
    }

    @Validated
    public static class Config
    {
        @NotEmpty
        private String param;

        @NotEmpty
        private String value;

        public Config() {
        }

        public String getParam() {
            return this.param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
