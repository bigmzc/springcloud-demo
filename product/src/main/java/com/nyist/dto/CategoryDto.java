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
public class CategoryDto implements Serializable {
    private String name;
    private String type;
    private List<ProductDto> foods = new ArrayList<>();
}
