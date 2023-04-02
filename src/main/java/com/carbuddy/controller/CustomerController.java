package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveCustomerRequestDto;
import com.carbuddy.repository.entity.Customer;
import com.carbuddy.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.carbuddy.constants.Endpoints.*;
@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveCustomerRequestDto dto){
        customerService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
