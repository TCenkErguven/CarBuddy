package com.carbuddy.service;

import com.carbuddy.dto.request.SaveBrandRequestDto;
import com.carbuddy.mapper.IBrandMapper;
import com.carbuddy.repository.IBrandRepository;
import com.carbuddy.repository.entity.Brand;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand,Long> {
    private final IBrandRepository iBrandRepository;
    public BrandService(IBrandRepository iBrandRepository){
        super(iBrandRepository);
        this.iBrandRepository = iBrandRepository;
    }

    public void save(SaveBrandRequestDto dto){
        Optional<Brand> brand = iBrandRepository.findByNameIgnoreCase(dto.getName());
        if(brand.isEmpty()){
            iBrandRepository.save(IBrandMapper.INSTANCE.toBrand(dto));
        }else{
            throw new NotFoundException(dto.getName() + ", bu marka veritabanına zaten kayıtlıdır.");
        }
    }
}
