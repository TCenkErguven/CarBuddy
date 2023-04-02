package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveRentalRequestDto;
import com.carbuddy.repository.entity.Rental;
import com.carbuddy.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.carbuddy.constants.Endpoints.*;
@RestController
@RequestMapping(RENTAL)
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(SaveRentalRequestDto dto){
        rentalService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll(){
        return ResponseEntity.ok(rentalService.findAll());
    }
}
