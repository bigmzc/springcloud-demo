package com.nyist.controller;

import com.nyist.dto.OrderDto;
import com.nyist.dto.ResultDto;
import com.nyist.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    @ResponseBody
    public ResultDto createOrder(@RequestBody OrderDto orderDto){
        ResultDto order = orderService.createOrder(orderDto);
        return order;
    }
}
