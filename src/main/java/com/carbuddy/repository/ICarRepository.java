package com.carbuddy.repository;

import com.carbuddy.repository.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
    List<Car> findCarsByNameStartingWithIgnoreCase(String carName);
    List<Car> findCarsByBrandId(Long brandId);
    @Query(value = "select * from tbl_car as car\n" +
            "inner join tbl_carcolor as cc on car.car_id = cc.car_id\n" +
            "where cc.color_id = ?1", nativeQuery = true)
    List<Car> findCarsByColor(Long colorId);

    List<Car> findCarsByDailyPriceLessThan(Double dailyPrice);
    @Query(value="select * from tbl_car as tc\n" +
            "inner join tbl_rental as tr on tc.car_id = tr.car_id\n"
            ,nativeQuery = true)
    List<Car> findCarsByRental();

}
