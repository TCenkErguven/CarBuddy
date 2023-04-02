package com.carbuddy.repository.entity.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbljoinrentdatecarnamebrandnamecustomercompany")
public class JoinRentDateCarBrandCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Long id;
    private Long rentDate;
    private String car_name;
    private String brand_name;
    private String companyName;
}
