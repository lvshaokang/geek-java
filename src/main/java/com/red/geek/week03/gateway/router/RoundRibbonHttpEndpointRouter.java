package com.red.geek.week03.gateway.router;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RoundRibbonHttpEndpointRouter 轮询路由
 *
 * @author red
 * @class_name RoundRibbonHttpEndpointRouter
 * @date 2021-04-04
 */
public class RoundRibbonHttpEndpointRouter implements HttpEndpointRouter {

    private static AtomicInteger indexAtomic = new AtomicInteger(0);

    @Override
    public String route(List<String> endpoints) {
        if (indexAtomic.get() >= endpoints.size()) {
            indexAtomic.set(0);
        }
        return endpoints.get(indexAtomic.getAndIncrement());
    }
}
