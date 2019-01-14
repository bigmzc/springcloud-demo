package com.nyist.feign;

import com.nyist.entity.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "PRODUCT")
public interface ProductFeign {

    @RequestMapping("/product/findProById")
    ProductInfo queryProductById(@RequestParam("productId") String productId);
}
