package com.nyist.service;

import com.nyist.dto.CategoryDto;
import com.nyist.dto.ProductDto;
import com.nyist.dto.ProductInfoDto;
import com.nyist.entity.ProductCategory;
import com.nyist.entity.ProductInfo;
import com.nyist.mapper.ProductCategoryMapper;
import com.nyist.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper infoMapper;

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ProductInfo> queryAllProduct() {
        List<ProductInfo> productInfos = infoMapper.selectAll();
        return productInfos;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ProductInfoDto queryProductInfo() {
        ProductInfoDto productInfoDto = new ProductInfoDto();
        productInfoDto.setCode("200");
        productInfoDto.setMsg("成功");
        List<ProductCategory> categories = categoryMapper.selectAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        //封装CategoryDto
        for (ProductCategory category : categories) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(category.getCategoryName());
            categoryDto.setType(category.getCategoryType().toString());
            //category_type查找类别下的商品
            ProductInfo info = new ProductInfo();
            info.setCategoryType(category.getCategoryType());
            List<ProductInfo> productInfos = infoMapper.select(info);
            List<ProductDto> productDtos = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                ProductDto productDto = new ProductDto();
                productDto.setId(Integer.valueOf(productInfo.getProductId()));
                productDto.setName(productInfo.getProductName());
                productDto.setPrice(productInfo.getProductPrice());
                productDto.setDescription(productInfo.getProductDescription());
                productDto.setIcon(productInfo.getProductIcon());
                productDtos.add(productDto);
            }
            categoryDto.setFoods(productDtos);
            categoryDtos.add(categoryDto);
        }
        productInfoDto.setData(categoryDtos);
        return productInfoDto;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ProductInfo queryProDuctById(String productId) {
        ProductInfo info = new ProductInfo();
        info.setProductId(productId);
        ProductInfo productInfo = infoMapper.selectByPrimaryKey(info);
        return productInfo;
    }
}
