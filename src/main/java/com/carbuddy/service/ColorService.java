package com.carbuddy.service;

import com.carbuddy.dto.request.SaveColorRequestDto;
import com.carbuddy.mapper.IColorMapper;
import com.carbuddy.repository.IColorRepository;
import com.carbuddy.repository.entity.Color;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color,Long> {
    private final IColorRepository iColorRepository;
    public ColorService(IColorRepository iColorRepository){
        super(iColorRepository);
        this.iColorRepository = iColorRepository;
    }
    public void save(SaveColorRequestDto dto){
        Optional<Color> color = iColorRepository.findByNameIgnoreCase(dto.getName());
        if(color.isEmpty()){
            iColorRepository.save(IColorMapper.INSTANCE.toColor(dto));
        }else{
            throw new NotFoundException(dto.getName() + ", bu marka veritabanına zaten kayıtlıdır.");
        }
    }

}
