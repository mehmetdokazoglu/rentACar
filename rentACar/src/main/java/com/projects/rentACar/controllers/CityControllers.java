package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CityService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CityDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_CITY')")
public class CityControllers {

    private final CityService cityService;

    @PostMapping("/add")
    public DataResult<CityDto> add(@Valid @RequestBody CityDto cityDto){
        return cityService.add(cityDto);
    }

    @GetMapping("/getAllCity")
    public DataResult<List<CityDto>> getAllCity(){
        return cityService.getAllCity();
    }

    @PutMapping("/update")
    public DataResult<CityDto> update(@RequestBody CityDto cityDto){
        return cityService.update(cityDto);
    }

    @DeleteMapping("/delete{cityId}")
    public Result delete(@PathVariable Integer cityId){
        return cityService.delete(cityId);
    }

    @GetMapping("/findByCityName")
    public DataResult<CityDto> findByCityName(@RequestParam String cityName){
        return cityService.findByCityName(cityName);
    }
}
