package com.projects.rentACar.controllers;

import com.projects.rentACar.business.FeatureService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.FeatureDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_FEATURE')")
public class FeatureControllers {

    private final FeatureService carFeatureService;

    @PostMapping("/add")
    public DataResult<FeatureDto> add(@Valid @RequestBody FeatureDto featureDto){
        return carFeatureService.add(featureDto);
    }

    @GetMapping("/getAllCar")
    public DataResult<List<FeatureDto>> getAllCar(){
        return carFeatureService.getAllCar();
    }

    @PutMapping("/update")
    public DataResult<FeatureDto> update(@RequestBody FeatureDto carFeatureDto){
        return carFeatureService.update(carFeatureDto);
    }

    @DeleteMapping("delete/{featureId}")
    public Result delete(@PathVariable Integer featureId){
        return carFeatureService.delete(featureId);
    }

    @GetMapping("/findByFeature")
    public DataResult<FeatureDto> findByFeature(@RequestParam String feature){
        return carFeatureService.findByFeature(feature);
    }

}
