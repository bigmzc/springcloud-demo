package com.nyist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String icon;
}
