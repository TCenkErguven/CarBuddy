package com.carbuddy.service;

import com.carbuddy.dto.request.SaveCarRequestDto;
import com.carbuddy.dto.response.FindCarByRentalResponse;
import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.exception.CarBuddyException;
import com.carbuddy.exception.ErrorType;
import com.carbuddy.mapper.ICarMapper;
import com.carbuddy.repository.ICarRepository;
import com.carbuddy.repository.entity.Brand;
import com.carbuddy.repository.entity.Car;
import com.carbuddy.repository.entity.Color;
import com.carbuddy.service.JoinTable.CarColorService;
import com.carbuddy.service.JoinTable.JoinColorBrandCarService;
import com.carbuddy.service.JoinTable.JoinRentDateCarBrandCompanyService;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import static com.carbuddy.exception.ErrorType.*;

import java.util.*;

@Service
public class CarService extends ServiceManager<Car,Long> {
    private final ICarRepository carRepository;
    private final BrandService brandService;
    private final ColorService colorService;
    private final CarColorService carColorService;
    private final JoinRentDateCarBrandCompanyService joinRentDateCarBrandCompanyService;
    private final JoinColorBrandCarService joinColorBrandCarService;

    public CarService(ICarRepository carRepository,
                      BrandService brandService,
                      CarColorService carColorService,
                      JoinColorBrandCarService joinColorBrandCarService,
                      JoinRentDateCarBrandCompanyService joinRentDateCarBrandCompanyService,
                      ColorService colorService){
        super(carRepository);
        this.carRepository = carRepository;
        this.brandService = brandService;
        this.colorService = colorService;
        this.carColorService = carColorService;
        this.joinColorBrandCarService = joinColorBrandCarService;
        this.joinRentDateCarBrandCompanyService = joinRentDateCarBrandCompanyService;
    }

    public void save(SaveCarRequestDto dto){
        //brand control
        Boolean colorStatus = true;
        Optional<Brand> brand = brandService.findById(dto.getBrandId());
        for(Long colorId : dto.getColorIds()){
            colorStatus = colorService.findById(colorId).isEmpty();
            if(colorStatus == true){
                break;
            }
        }
        if(brand.isEmpty()){
            throw new CarBuddyException(NOT_FOUND_BRAND);
        }else if(colorStatus){
            throw new CarBuddyException(NOT_FOUND_COLOR);
        }else{
            Car car = save(ICarMapper.INSTANCE.toCar(dto));
            dto.getColorIds().forEach(colorId -> {
                carColorService.save(car.getId(), colorId);
            });
        }
    }
    public List<Car> findCarsByNameStartingWithIgnoreCase(String carName){
        List<Car> carList = carRepository.findCarsByNameStartingWithIgnoreCase(carName);
        if(carList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND);
        }
        return carList;
    }
    public List<Car> findCarsByBrandId(Long brandId){
        List<Car> carList = carRepository.findCarsByBrandId(brandId);
        if(carList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND);
        }
        return carList;
    }
    public List<Car> findCarsByColor(Long colorId){
        List<Car> carList = carRepository.findCarsByColor(colorId);
        if(carList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND);
        }
        return carList;
    }
    public List<FindJoinColorBrandCarResponseDto> findAllColorBrandCar(){
        List<FindJoinColorBrandCarResponseDto> carInfoList = joinColorBrandCarService.findAllColorBrandCar();
        if(carInfoList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND);
        }
        return carInfoList;
    }

    public List<Car> findCarsByDailyPriceLessThan(Double dailyPrice){
        List<Car> carInfoList = carRepository.findCarsByDailyPriceLessThan(dailyPrice);
        if(carInfoList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND_PRICE);
        }
        return carRepository.findCarsByDailyPriceLessThan(dailyPrice);
    }
    public List<FindCarByRentalResponse> findCarsByRental(){
        List<Car> carList = carRepository.findCarsByRental();
        if(carList.isEmpty()){
            throw new CarBuddyException(NOT_FOUND_RENTAL);
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
            throw new CarBuddyException(NOT_FOUND);
        }
        return list;
    }
}
