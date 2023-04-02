package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveRentalRequestDto;
import com.carbuddy.repository.entity.Rental;
import com.carbuddy.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.carbuddy.constants.Endpoints.*;
@RestController
@RequestMapping(RENTAL)
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveRentalRequestDto dto){
        rentalService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll(){
        return ResponseEntity.ok(rentalService.findAll());
    }
}
