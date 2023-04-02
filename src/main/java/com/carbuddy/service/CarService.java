package com.carbuddy.service;

import com.carbuddy.dto.request.SaveCarRequestDto;
import com.carbuddy.dto.response.FindCarByRentalResponse;
import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.mapper.ICarMapper;
import com.carbuddy.repository.ICarRepository;
import com.carbuddy.repository.entity.Brand;
import com.carbuddy.repository.entity.Car;
import com.carbuddy.service.JoinTable.CarColorService;
import com.carbuddy.service.JoinTable.JoinColorBrandCarService;
import com.carbuddy.service.JoinTable.JoinRentDateCarBrandCompanyService;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

@Service
public class CarService extends ServiceManager<Car,Long> {
    private final ICarRepository carRepository;
    private final BrandService brandService;
    private final CarColorService carColorService;
    private final JoinRentDateCarBrandCompanyService joinRentDateCarBrandCompanyService;
    private final JoinColorBrandCarService joinColorBrandCarService;

    public CarService(ICarRepository carRepository,
                      BrandService brandService,
                      CarColorService carColorService,
                      JoinColorBrandCarService joinColorBrandCarService,
                      JoinRentDateCarBrandCompanyService joinRentDateCarBrandCompanyService){
        super(carRepository);
        this.carRepository = carRepository;
        this.brandService = brandService;
        this.carColorService = carColorService;
        this.joinColorBrandCarService = joinColorBrandCarService;
        this.joinRentDateCarBrandCompanyService = joinRentDateCarBrandCompanyService;
    }

    public void save(SaveCarRequestDto dto){
        //brand control
        Optional<Brand> brand = brandService.findById(dto.getBrandId());
        if(brand.isEmpty()){
            throw new NotFoundException("Bu  marka veritabanında tanımlı değildir.");
        }else {
            Car car = save(ICarMapper.INSTANCE.toCar(dto));
            dto.getColorIds().forEach(colorId -> {
                carColorService.save(car.getId(), colorId);
            });
        }
    }
    public List<Car> findCarsByNameStartingWithIgnoreCase(String carName){
        return carRepository.findCarsByNameStartingWithIgnoreCase(carName);
    }
    public List<Car> findCarsByBrandId(Long brandId){
        return carRepository.findCarsByBrandId(brandId);
    }
    public List<Car> findCarsByColor(Long colorId){
        return carRepository.findCarsByColor(colorId);
    }
    public List<FindJoinColorBrandCarResponseDto> findAllColorBrandCar(){
        List<FindJoinColorBrandCarResponseDto> carInfoList = joinColorBrandCarService.findAllColorBrandCar();
        if(carInfoList.isEmpty()){
            throw new RuntimeException("Veritabanında araba bulunamamıştır.");
        }
        return carInfoList;
    }

    public List<Car> findCarsByDailyPriceLessThan(Double dailyPrice){
        return carRepository.findCarsByDailyPriceLessThan(dailyPrice);
    }
    public List<FindCarByRentalResponse> findCarsByRental(){
        List<Car> carList = carRepository.findCarsByRental();
        if(carList.isEmpty()){
            throw new RuntimeException("Veritabanında kiralık araba bulunamamıştır.");
        }
        List<FindCarByRentalResponse> carByRentalResponse = new ArrayList<>();
        carList.forEach(car -> {
            carByRentalResponse.add(ICarMapper.INSTANCE
                    .findCarByRentalResponse(car));
        });
        return carByRentalResponse;
    }
    public List<FindJoinRentalCarCustomerDto> findDateCarBrandCompany(){
        List<FindJoinRentalCarCustomerDto> list = joinRentDateCarBrandCompanyService.findDateCarBrandCompany();
        if(list.isEmpty()){
            throw new NotFoundException("Veritabanında ilgili veriler bulunamamıştır.");
        }
        return list;
    }
}
