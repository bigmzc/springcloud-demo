package com.nyist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private Double productPrice;
    private String productIcon;
    private Integer productQuantity;
    private Date createTime;
    private Date updateTime;
}