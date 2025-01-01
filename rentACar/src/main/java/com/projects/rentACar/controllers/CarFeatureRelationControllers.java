package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CarFeatureRelationService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarFeatureRelationDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carFeatureRelations")
@RequiredArgsConstructor
public class CarFeatureRelationControllers {

    private final CarFeatureRelationService carFeatureRelationService;

    @PostMapping("/add")
    public DataResult<CarFeatureRelationDto> add(@RequestBody @Valid CarFeatureRelationDto carFeatureRelationDto){
        return carFeatureRelationService.add(carFeatureRelationDto);
    }

    @GetMapping("/getAllCar")
    public DataResult<List<CarFeatureRelationDto>> getAllCar(){
        return carFeatureRelationService.getAllCar();
    }

    @PutMapping("/update")
    public DataResult<CarFeatureRelationDto> update(@RequestBody CarFeatureRelationDto carFeatureRelationDto){
        return carFeatureRelationService.update(carFeatureRelationDto);
    }

    @DeleteMapping("/delete/{carFeatureRelationId}")
    public Result delete(Integer carFeatureRelationId){
        return carFeatureRelationService.delete(carFeatureRelationId);
    }
}
