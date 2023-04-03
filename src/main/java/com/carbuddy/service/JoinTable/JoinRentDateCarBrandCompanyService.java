package com.carbuddy.service.JoinTable;

import com.carbuddy.dto.response.jointable.FindJoinColorBrandCarResponseDto;
import com.carbuddy.dto.response.jointable.FindJoinRentalCarCustomerDto;
import com.carbuddy.exception.CarBuddyException;
import com.carbuddy.exception.ErrorType;
import com.carbuddy.mapper.Jointable.IFindJoinColorBrandCarMapper;
import com.carbuddy.mapper.Jointable.IFindJoinRentDateCarBrandCompanyMapper;
import com.carbuddy.repository.Jointable.IJoinRentDateCarBrandCompanyRepository;
import com.carbuddy.repository.entity.JoinTable.JoinColorBrandCar;
import com.carbuddy.repository.entity.JoinTable.JoinRentDateCarBrandCompany;
import com.carbuddy.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinRentDateCarBrandCompanyService extends ServiceManager<JoinRentDateCarBrandCompany,Long> {

    private final IJoinRentDateCarBrandCompanyRepository iJoinRentDateCarBrandCompanyRepository;

    public JoinRentDateCarBrandCompanyService(IJoinRentDateCarBrandCompanyRepository iJoinRentDateCarBrandCompanyRepository) {
        super(iJoinRentDateCarBrandCompanyRepository);
        this.iJoinRentDateCarBrandCompanyRepository = iJoinRentDateCarBrandCompanyRepository;
    }

    public List<FindJoinRentalCarCustomerDto> findDateCarBrandCompany(){
        List<JoinRentDateCarBrandCompany> JoinRentDateCarBrandCompanyList = iJoinRentDateCarBrandCompanyRepository.findDateCarBrandCompany();
        List<FindJoinRentalCarCustomerDto> findAllRentDateCarBrandCompanyList = new ArrayList<>();
        JoinRentDateCarBrandCompanyList.forEach(item ->{
            findAllRentDateCarBrandCompanyList.add(IFindJoinRentDateCarBrandCompanyMapper.INSTANCE.findJoinRentalCarCustomerDto(item));
        });
        if(findAllRentDateCarBrandCompanyList.isEmpty()){
            throw new CarBuddyException(ErrorType.NOT_FOUND);
        }
        return findAllRentDateCarBrandCompanyList;
    }
}
