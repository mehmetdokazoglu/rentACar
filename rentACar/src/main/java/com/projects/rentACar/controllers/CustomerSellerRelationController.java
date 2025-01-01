package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CustomerSellerRelationService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.dtos.CustomerSellerRelationDto;
import com.projects.rentACar.dtos.CustomerSellerRelationFilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerSellerRelations")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_ADMIN')")
public class CustomerSellerRelationController {

    private final CustomerSellerRelationService customerSellerRelationService;

    @PostMapping("/add")
    public DataResult<CustomerSellerRelationDto> add(@RequestBody CustomerSellerRelationDto customerSellerRelationDto){
       return customerSellerRelationService.add(customerSellerRelationDto);
    }

    @GetMapping("/getAllRelation")
    public DataResult<List<CustomerSellerRelationDto>> getAllRelation(){
        return customerSellerRelationService.getAllRelation();
    }

    @PostMapping("/filter")
    public DataResult<List<CustomerSellerRelationDto>> filter(@RequestBody CustomerSellerRelationFilterDto customerSellerRelationFilterDto) {
        return customerSellerRelationService.filter(customerSellerRelationFilterDto);
    }
}
