package com.nyist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    private String name;
    private String phone;
    private String address;
    private String openid;
    private List<CartDto> items = new ArrayList<>();
}
