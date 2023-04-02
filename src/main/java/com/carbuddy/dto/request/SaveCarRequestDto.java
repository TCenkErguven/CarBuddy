package com.carbuddy.dto.request;

import com.carbuddy.repository.entity.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCarRequestDto {
    private String name;
    private Integer modelYear;
    private Double dailyPrice;
    private String description;
    private Long brandId;
    private List<Long> colorIds;
}
