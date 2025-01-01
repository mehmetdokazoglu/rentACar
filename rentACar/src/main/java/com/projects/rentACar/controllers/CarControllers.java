package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CarService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_CAR')")
public class CarControllers {

    private final CarService carService;

    @PreAuthorize("hasAuthority('ADD_CAR')")
    @PostMapping("/add")
    public DataResult<CarDto> add(@RequestBody @Valid CarDto carDto) throws Exception {
        return carService.add(carDto);
    }

    @PreAuthorize("hasAuthority('GET_ALL_CAR')")
    @GetMapping("/getAllCar")
    public DataResult<List<CarDto>>getAllCar(){
        return carService.getAllCar();
    }

    @PutMapping("/update")
    public DataResult<CarDto> update(@RequestBody CarDto carDto){
        return carService.update(carDto);
    }

    @GetMapping("/findByCarName")
    public DataResult<CarDto> findByCarName(@RequestParam String carName){
        return carService.findByCarName(carName);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer carId) {
        return carService.delete(carId);
    }
}
