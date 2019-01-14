package com.nyist.feign;

import com.nyist.dto.OrderDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(serviceId = "ORDER")
public interface FeignInvoke {

    @RequestMapping(value = "/order/createOrder",method = RequestMethod.POST)
    String createOrder(OrderDto orderDto);
}
