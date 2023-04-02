package com.carbuddy.repository.Jointable;

import com.carbuddy.repository.entity.JoinTable.JoinRentDateCarBrandCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoinRentDateCarBrandCompanyRepository extends JpaRepository<JoinRentDateCarBrandCompany,Long> {
    @Query(value = "select r.rid,r.rent_date,ca.car_name,b.brand_name,cc.company_name from tbl_car as ca\n" +
            "inner join tbl_brand as b on b.bid = ca.brand_id\n" +
            "inner join tbl_rental as r on r.car_id = ca.car_id\n" +
            "inner join tbl_customer as cc on cc.customer_id = r.customer_id",nativeQuery = true)
    List<JoinRentDateCarBrandCompany> findDateCarBrandCompany();
}
