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
public class ProductCategory implements Serializable {
    @Id
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}