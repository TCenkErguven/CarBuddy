package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveCarRequestDto;
import com.carbuddy.dto.response.FindCarByRentalResponse;
import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.repository.entity.Car;
import com.carbuddy.repository.entity.JoinTable.JoinRentDateCarBrandCompany;
import com.carbuddy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.carbuddy.constants.Endpoints.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(SaveCarRequestDto dto){
        carService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }
    @GetMapping(FIND_CARS_BY_NAME)
    public ResponseEntity<List<Car>> findCarsByNameStartingWithIgnoreCase(String carName){
        return ResponseEntity.ok(carService.findCarsByNameStartingWithIgnoreCase(carName));
    }
    @GetMapping(FIND_CARS_BY_BRAND)
    public ResponseEntity<List<Car>> findCarsByBrandId(Long brandId){
        return ResponseEntity.ok(carService.findCarsByBrandId(brandId));
    }
    @GetMapping(FIND_CARS_BY_COLOR)
    public ResponseEntity<List<Car>> findCarsByColor(Long colorId){
        return ResponseEntity.ok(carService.findCarsByColor(colorId));
    }
    @GetMapping(FIND_CARS_BY_DAILY_PRICE_LESS_THAN)
    public ResponseEntity<List<Car>> findCarsByDailyPriceLessThan(Double dailyPrice){
        return ResponseEntity.ok(carService.findCarsByDailyPriceLessThan(dailyPrice));
    }
    @GetMapping(FIND_CARS_BY_RENTAL)
    public ResponseEntity<List<FindCarByRentalResponse>> findCarsByRental(){
        return ResponseEntity.ok(carService.findCarsByRental());
    }
    @GetMapping(FIND_COLOR_BRAND_CAR)
    public ResponseEntity<List<FindJoinColorBrandCarResponseDto>> findAllColorBrandCar(){
        return ResponseEntity.ok(carService.findAllColorBrandCar());
    }
    @GetMapping(FIND_DATE_CAR_BRAND_COMPANY)
    public ResponseEntity<List<FindJoinRentalCarCustomerDto>> findDateCarBrandCompany(){
        return ResponseEntity.ok(carService.findDateCarBrandCompany());
    }


}
