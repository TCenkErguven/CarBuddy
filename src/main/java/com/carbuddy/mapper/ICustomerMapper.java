package com.carbuddy.mapper;

import com.carbuddy.dto.request.SaveCustomerRequestDto;
import com.carbuddy.dto.response.FindCustomerCompany;
import com.carbuddy.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);
    Customer toCustomer(final SaveCustomerRequestDto dto);
    FindCustomerCompany findCustomerCompany(final Customer customer);
}
