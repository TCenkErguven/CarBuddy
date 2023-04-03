package com.carbuddy.service.JoinTable;

import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.exception.CarBuddyException;
import com.carbuddy.exception.ErrorType;
import com.carbuddy.mapper.Jointable.IFindJoinColorBrandCarMapper;
import com.carbuddy.repository.Jointable.IJoinColorBrandCarRepository;
import com.carbuddy.repository.entity.JoinTable.JoinColorBrandCar;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinColorBrandCarService extends ServiceManager<JoinColorBrandCar,Long> {
    private final IJoinColorBrandCarRepository iJoinColorBrandCarRepository;
    public JoinColorBrandCarService(IJoinColorBrandCarRepository iJoinColorBrandCarRepository){
        super(iJoinColorBrandCarRepository);
        this.iJoinColorBrandCarRepository = iJoinColorBrandCarRepository;
    }
    public List<FindJoinColorBrandCarResponseDto> findAllColorBrandCar(){
        List<JoinColorBrandCar> JoinColorBrandCarList = iJoinColorBrandCarRepository.joinColorBrandCar();
        List<FindJoinColorBrandCarResponseDto> findAllColorBrandCarList = new ArrayList<>();
        JoinColorBrandCarList.forEach(item ->{
            findAllColorBrandCarList.add(IFindJoinColorBrandCarMapper.INSTANCE.findJoinColorBrandCarResponseDto(item));
        });
        if(findAllColorBrandCarList.isEmpty()){
            throw new CarBuddyException(ErrorType.NOT_FOUND);
        }
        return findAllColorBrandCarList;
    }

}
