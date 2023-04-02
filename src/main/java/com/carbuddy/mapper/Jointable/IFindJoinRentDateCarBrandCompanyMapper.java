package com.carbuddy.mapper.Jointable;

import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.repository.entity.JoinTable.JoinRentDateCarBrandCompany;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IFindJoinRentDateCarBrandCompanyMapper {
    IFindJoinRentDateCarBrandCompanyMapper INSTANCE = Mappers.getMapper(IFindJoinRentDateCarBrandCompanyMapper.class);
    FindJoinRentalCarCustomerDto findJoinRentalCarCustomerDto(final JoinRentDateCarBrandCompany joinRentDateCarBrandCompany);

}
