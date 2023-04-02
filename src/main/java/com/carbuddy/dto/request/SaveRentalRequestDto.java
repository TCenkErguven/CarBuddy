package com.carbuddy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveRentalRequestDto {
    private Long rentDate;
    private Long customerId;
    private Long carId;
}
