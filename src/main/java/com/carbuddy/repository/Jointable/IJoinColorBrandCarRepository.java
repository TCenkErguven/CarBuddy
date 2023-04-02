package com.carbuddy.repository.Jointable;

import com.carbuddy.repository.entity.JoinTable.JoinColorBrandCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoinColorBrandCarRepository extends JpaRepository<JoinColorBrandCar,Long> {
        @Query(value = "select cc.color_id,ca.car_name,c.color_name,b.brand_name from tbl_carcolor as cc\n" +
                "inner join tbl_color as c on c.color_id = cc.color_id\n" +
                "inner join tbl_car as ca on ca.car_id = cc.car_id\n" +
                "inner join tbl_brand as b on b.bid = ca.brand_id",nativeQuery = true)
        List<JoinColorBrandCar> joinColorBrandCar();
}
