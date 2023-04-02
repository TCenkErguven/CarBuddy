package com.carbuddy.mapper.Jointable;

import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.repository.entity.JoinTable.JoinColorBrandCar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IFindJoinColorBrandCarMapper {
    IFindJoinColorBrandCarMapper INSTANCE = Mappers.getMapper(IFindJoinColorBrandCarMapper.class);
    FindJoinColorBrandCarResponseDto findJoinColorBrandCarResponseDto(final JoinColorBrandCar joinColorBrandCar);
}
