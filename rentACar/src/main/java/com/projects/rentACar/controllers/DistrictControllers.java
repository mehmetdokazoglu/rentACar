package com.projects.rentACar.controllers;

import com.projects.rentACar.business.DistrictService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.DistrictDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_DISTRICT')")
public class DistrictControllers {

    private final DistrictService districtService;

    @PostMapping("/add")
    public DataResult<DistrictDto> add(@Valid @RequestBody DistrictDto districtDto){
        return districtService.add(districtDto);
    }

    @GetMapping("/getAllDistrict")
    public DataResult<List<DistrictDto>> getAllDistrict(){
        return districtService.getAllDistrict();
    }

    @PutMapping("/update")
    public DataResult<DistrictDto> update(@RequestBody DistrictDto districtDto){
        return districtService.update(districtDto);
    }

    @DeleteMapping("/delete{districtId}")
    public Result delete(@PathVariable Integer districtId){
        return districtService.delete(districtId);
    }

    @GetMapping("/findByDistrictName")
    public DataResult<DistrictDto> findByDistrictName(@RequestParam String districtName){
        return districtService.findByDistrictName(districtName);
    }
}
