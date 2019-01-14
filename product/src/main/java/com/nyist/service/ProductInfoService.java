package com.nyist.service;

import com.nyist.dto.ProductInfoDto;
import com.nyist.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> queryAllProduct();
    ProductInfoDto queryProductInfo();
    ProductInfo queryProDuctById(String productId);
}
