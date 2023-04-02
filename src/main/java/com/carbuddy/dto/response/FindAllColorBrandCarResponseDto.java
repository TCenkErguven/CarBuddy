package com.carbuddy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllColorBrandCarResponseDto {
    private String brand_name;
    private String car_name;
    private List<String> color_name;
}
