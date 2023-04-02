package com.carbuddy.service;

import com.carbuddy.dto.request.SaveRentalRequestDto;
import com.carbuddy.mapper.IRentalMapper;
import com.carbuddy.repository.IRentalRepository;
import com.carbuddy.repository.entity.Car;
import com.carbuddy.repository.entity.Customer;
import com.carbuddy.repository.entity.Rental;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService extends ServiceManager<Rental,Long> {
    private final IRentalRepository iRentalRepository;
    private final CarService carService;
    private final CustomerService customerService;
    public RentalService(IRentalRepository iRentalRepository,
                         CarService carService,
                         CustomerService customerService){
        super(iRentalRepository);
        this.iRentalRepository = iRentalRepository;
        this.carService = carService;
        this.customerService = customerService;
    }
    public void save(SaveRentalRequestDto dto){
        Optional<Car> optionalCar = carService.findById(dto.getCarId());
        Optional<Customer> optionalCustomer = customerService.findById(dto.getCustomerId());
        if(optionalCar.isEmpty()||optionalCustomer.isEmpty()){
            throw new NotFoundException("İstenilen araba veya müşteri veri tabanına kayıtlı değildir.");
        }else {
            iRentalRepository.save(IRentalMapper.INSTANCE.toRental(dto));
        }
    }
    
}
