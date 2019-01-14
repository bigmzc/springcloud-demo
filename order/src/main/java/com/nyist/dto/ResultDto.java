package com.nyist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto implements Serializable {
    private String code;
    private String msg;
    private Map<String,String> data = new HashMap<>();
}
