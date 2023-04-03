package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveCarRequestDto;
import com.carbuddy.dto.response.FindCarByRentalResponse;
import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.repository.entity.Car;
import com.carbuddy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.carbuddy.constants.Endpoints.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveCarRequestDto dto){
        carService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }
    @GetMapping(FIND_CARS_BY_NAME+"/{carName}")
    public ResponseEntity<List<Car>> findCarsByNameStartingWithIgnoreCase(@PathVariable String carName){
        return ResponseEntity.ok(carService.findCarsByNameStartingWithIgnoreCase(carName));
    }
    @GetMapping(FIND_CARS_BY_BRAND+"/{brandId}")
    public ResponseEntity<List<Car>> findCarsByBrandId(@PathVariable Long brandId){
        return ResponseEntity.ok(carService.findCarsByBrandId(brandId));
    }
    @GetMapping(FIND_CARS_BY_COLOR+"/{colorId}")
    public ResponseEntity<List<Car>> findCarsByColor(@PathVariable Long colorId){
        return ResponseEntity.ok(carService.findCarsByColor(colorId));
    }
    @GetMapping(FIND_CARS_BY_DAILY_PRICE_LESS_THAN+"/{dailyPrice}")
    public ResponseEntity<List<Car>> findCarsByDailyPriceLessThan(@PathVariable Double dailyPrice){
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
