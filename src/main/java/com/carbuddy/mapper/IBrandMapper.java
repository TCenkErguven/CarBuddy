package com.carbuddy.mapper;

import com.carbuddy.dto.request.SaveBrandRequestDto;
import com.carbuddy.repository.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IBrandMapper {
    IBrandMapper INSTANCE = Mappers.getMapper(IBrandMapper.class);
    Brand toBrand(final SaveBrandRequestDto dto);
}
