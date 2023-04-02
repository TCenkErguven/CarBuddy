package com.carbuddy.controller;

import com.carbuddy.dto.request.SaveColorRequestDto;
import com.carbuddy.repository.entity.Color;
import com.carbuddy.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.carbuddy.constants.Endpoints.*;

@RestController
@RequestMapping(COLOR)
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;
    @PostMapping(SAVE)
    public ResponseEntity<Void> save(SaveColorRequestDto dto){
        colorService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findAll(){
        return ResponseEntity.ok(colorService.findAll());
    }
}
