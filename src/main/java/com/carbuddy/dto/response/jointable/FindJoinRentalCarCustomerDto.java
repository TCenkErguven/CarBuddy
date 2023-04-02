package com.carbuddy.dto.response.jointable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindJoinRentalCarCustomerDto {
    private Long rentDate;
    private String car_name;
    private String brand_name;
    private String companyName;
}
