package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CarSellerRelationService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarSellerRelationDto;
import com.projects.rentACar.dtos.CarSellerRelationFilterDto;
import com.projects.rentACar.entities.CarSellerRelation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/carSellerRelations")
@RequiredArgsConstructor
public class CarSellerRelationControllers {

    private final CarSellerRelationService carSellerRelationService;

//    @PostMapping("/add")
//    public DataResult<CarSellerRelationDto> add(@RequestBody CarSellerRelationDto carSellerRelationDto){
//        return carSellerRelationService.add(carSellerRelationDto);
//    }

    @PreAuthorize("hasAuthority('ADD_CAR')")
    @PostMapping("/add")
    public ResponseEntity<DataResult<CarSellerRelationDto>> add(@Valid @RequestBody CarSellerRelationDto carSellerRelationDto){
        DataResult<CarSellerRelationDto> result = carSellerRelationService.add(carSellerRelationDto);
        return new ResponseEntity<>(result, result.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('GET_ALL_CAR')")
    @GetMapping("/getAllCar")
    public DataResult<List<CarSellerRelationDto>> getAllCar(){
        return carSellerRelationService.getAllCar();
    }

    @PreAuthorize("hasAuthority('MANAGE_OWN_CARS') and @carSellerRelationRepository.findBySeller_CompanyName(#carSellerRelationDto.sellerDto.companyName) != null " +
            "and @carSellerRelationRepository.findBySeller_CompanyName(@carSellerRelationDto.sellerDto.companyName).seller.getCompanyName() == authentication.principal.companyName")
    @PutMapping("/update")
    public DataResult<CarSellerRelationDto> update(@RequestBody CarSellerRelationDto carSellerRelationDto){
        return carSellerRelationService.update(carSellerRelationDto);
    }

    @PreAuthorize("hasAuthority('MANAGE_OWN_CARS') and @carSellerRelationRepository.findBySeller_CompanyName(#carSellerRelationDto.sellerDto.companyName) != null " +
            "and @carSellerRelationRepository.findBySeller_CompanyName(@carSellerRelationDto.sellerDto.companyName).seller.getCompanyName() == authentication.principal.companyName")
    @DeleteMapping("/delete/{carSellerRelationId}")
    public Result delete(Integer carSellerRelationId){
        return carSellerRelationService.delete(carSellerRelationId);
    }

    @GetMapping("/findBySeller_CompanyName")
    public DataResult<List<CarSellerRelationDto>> findBySeller_CompanyName(String companyName){
        return carSellerRelationService.findBySeller_CompanyName(companyName);
    }

    @PostMapping("/filter")
    public DataResult<List<CarSellerRelationDto>> filter(@RequestBody CarSellerRelationFilterDto carSellerRelationFilterDto,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate){
        return carSellerRelationService.filter(carSellerRelationFilterDto, startDate, endDate);
    }
}
