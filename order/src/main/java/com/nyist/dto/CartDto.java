package com.nyist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable {
    private String productId;
    private Integer productQuantity;
}
