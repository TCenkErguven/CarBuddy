package com.carbuddy.dto.response.jointable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindJoinColorBrandCarResponseDto {
    private String brand_name;
    private String car_name;
    private String color_name;
}
