package com.carbuddy.repository.Jointable;

import com.carbuddy.repository.entity.JoinTable.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarColorRepository extends JpaRepository<CarColor,Long> {
}
