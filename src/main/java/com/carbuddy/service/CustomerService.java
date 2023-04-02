package com.carbuddy.service;

import com.carbuddy.dto.request.SaveCustomerRequestDto;
import com.carbuddy.mapper.ICustomerMapper;
import com.carbuddy.repository.ICustomerRepository;
import com.carbuddy.repository.entity.Customer;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository iCustomerRepository;
    public CustomerService(ICustomerRepository iCustomerRepository){
        super(iCustomerRepository);
        this.iCustomerRepository = iCustomerRepository;
    }

    public void save(SaveCustomerRequestDto dto){
        iCustomerRepository.save(ICustomerMapper.INSTANCE.toCustomer(dto));
    }


}
