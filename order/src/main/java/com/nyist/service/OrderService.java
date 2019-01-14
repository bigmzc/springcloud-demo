package com.nyist.service;

import com.nyist.dto.OrderDto;
import com.nyist.dto.ResultDto;
import com.nyist.entity.ProductInfo;

public interface OrderService {
    ResultDto createOrder(OrderDto orderDto);
}
