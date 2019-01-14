package com.nyist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo implements Serializable {
    @Id
    private String productId;
    private String productName;
    private Double productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}