package com.carbuddy.mapper;

import com.carbuddy.dto.request.SaveCarRequestDto;
import com.carbuddy.dto.response.FindCarByRentalResponse;
import com.carbuddy.repository.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICarMapper {
    ICarMapper INSTANCE = Mappers.getMapper(ICarMapper.class);
    Car toCar(final SaveCarRequestDto dto);
    FindCarByRentalResponse findCarByRentalResponse(final Car car);
}
