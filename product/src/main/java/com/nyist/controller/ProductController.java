package com.nyist.controller;

import com.nyist.dto.CartDto;
import com.nyist.dto.OrderDto;
import com.nyist.dto.ProductInfoDto;
import com.nyist.entity.ProductInfo;
import com.nyist.feign.FeignInvoke;
import com.nyist.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private FeignInvoke feignInvoke;

    @RequestMapping("/queryAll")
    public String queryAllProduct(Model model) {
        List<ProductInfo> productInfos = productInfoService.queryAllProduct();
        model.addAttribute("list", productInfos);
        return "forward:/product.jsp";
    }

    //@RequestMapping(value = "/list",produces = "application/json; charset=utf-8")
    @RequestMapping("/list")
    @ResponseBody
    public ProductInfoDto queryProductInfo() {
        ProductInfoDto productInfoDto = productInfoService.queryProductInfo();
        return productInfoDto;
    }


    @RequestMapping("/add")
    public String addToCart(HttpSession session, String id) {
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (cart.containsKey(id)) {
            //包含该商品 数量++
            Integer count = cart.get(id);
            cart.put(id, count + 1);
        } else {
            cart.put(id, 1);
        }
        session.setAttribute("cart",cart);

        return "redirect:/cart.jsp";
    }

    @RequestMapping("/order")
    @ResponseBody
    public String toOrder(HttpSession session){
        OrderDto orderDto = new OrderDto();
        orderDto.setName("你来沈阳我等你");
        orderDto.setPhone("13271301389");
        orderDto.setAddress("北京市昌平区");
        orderDto.setOpenid("wo20111022");

        List<CartDto> cartDtos = new ArrayList<>();
        Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            CartDto cartDto = new CartDto();
            cartDto.setProductId(entry.getKey());
            cartDto.setProductQuantity(entry.getValue());
            cartDtos.add(cartDto);
        }
        orderDto.setItems(cartDtos);
        String order = feignInvoke.createOrder(orderDto);
        return order;
    }

    @RequestMapping("/findProById")
    @ResponseBody
    public ProductInfo queryProductById(String productId){
        ProductInfo productInfo = productInfoService.queryProDuctById(productId);
        return productInfo;
    }
}
