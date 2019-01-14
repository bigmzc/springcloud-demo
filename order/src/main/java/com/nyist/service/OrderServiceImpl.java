package com.nyist.service;

import com.nyist.dto.CartDto;
import com.nyist.dto.OrderDto;
import com.nyist.dto.ResultDto;
import com.nyist.entity.OrderDetail;
import com.nyist.entity.OrderMaster;
import com.nyist.entity.ProductInfo;
import com.nyist.feign.ProductFeign;
import com.nyist.mapper.OrderDetailMapper;
import com.nyist.mapper.OrderMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper masterMapper;

    @Autowired
    private OrderDetailMapper detailMapper;

    @Autowired
    private ProductFeign productFeign;

    @Override
    public ResultDto createOrder(OrderDto orderDto) {
        OrderMaster master = new OrderMaster();
        OrderDetail detail = new OrderDetail();


        //生成订单，保证发生异常时 订单与订单项同时回滚
        String orderId = UUID.randomUUID().toString();
        master.setOrderId(orderId);
        master.setBuyerName(orderDto.getName());
        master.setBuyerIphone(orderDto.getPhone());
        master.setBuyerAddress(orderDto.getAddress());
        master.setBuyerOpenid(orderDto.getOpenid());
        master.setCreateTime(new Date());
        master.setOrderStatus(0);
        master.setPayStayus(0);
        master.setUpdateTime(new Date());
        Double amount = 0.0;
        List<CartDto> items = orderDto.getItems();
        for (CartDto item : items) {
            String productId = item.getProductId();
            //根据ID远程调用product拿到商品详情
            ProductInfo productInfo = productFeign.queryProductById(productId);
            Double productPrice = productInfo.getProductPrice();
            amount += item.getProductQuantity()*productPrice;

            detail.setCreateTime(new Date());
            detail.setDetailId(UUID.randomUUID().toString());
            detail.setOrderId(orderId);
            detail.setProductIcon(productInfo.getProductIcon());
            detail.setProductId(productId);
            detail.setProductName(productInfo.getProductName());
            detail.setProductPrice(productPrice);
            detail.setProductQuantity(item.getProductQuantity());
            detail.setUpdateTime(new Date());
            detailMapper.insert(detail);
        }
        master.setOrderAmount(amount);
        masterMapper.insert(master);

        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("成功");
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderId);
        resultDto.setData(map);
        return resultDto;
    }
}
