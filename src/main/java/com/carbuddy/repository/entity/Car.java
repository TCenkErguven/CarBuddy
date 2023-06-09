package com.carbuddy.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private Long id;
    @NotBlank
    @Column(length = 50,name = "car_name")
    private String name;
    @NotNull
    @Column(length = 4)
    private Integer modelYear;
    @NotNull
    private Double dailyPrice;
    @NotBlank
    private String description;
    @NotNull
    private Long brandId;

    //Brand ManyToOne -
    //Color ManyToMany
    //Customer ManyToOne -

}
