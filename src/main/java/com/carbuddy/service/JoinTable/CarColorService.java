package com.carbuddy.service.JoinTable;

import com.carbuddy.exception.CarBuddyException;
import com.carbuddy.exception.ErrorType;
import com.carbuddy.repository.Jointable.ICarColorRepository;
import com.carbuddy.repository.entity.Color;
import com.carbuddy.repository.entity.JoinTable.CarColor;
import com.carbuddy.service.ColorService;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class CarColorService extends ServiceManager<CarColor,Long> {
    private final ICarColorRepository iCarColorRepository;
    private final ColorService colorService;
    public CarColorService(ICarColorRepository iCarColorRepository,
                           ColorService colorService){
        super(iCarColorRepository);
        this.iCarColorRepository = iCarColorRepository;
        this.colorService = colorService;
    }

    public void save(Long carId,Long colorId){
        Optional<Color> color = colorService.findById(colorId);
        if(color.isEmpty()){
            throw new CarBuddyException(ErrorType.NOT_FOUND_COLOR);
        }else {
            save(CarColor.builder()
                    .carId(carId)
                    .colorId(colorId)
                    .build());
        }
    }
}
