package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveBrandRequestDto;
import com.carbuddy.repository.entity.Brand;
import com.carbuddy.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.carbuddy.constants.Endpoints.*;

import java.util.List;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveBrandRequestDto dto){
        brandService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findAllBrand(){
        return ResponseEntity.ok(brandService.findAll());
    }
}
