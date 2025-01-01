package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarSellerRelationDto;
import com.projects.rentACar.dtos.CarSellerRelationFilterDto;
import com.projects.rentACar.entities.CarSellerRelation;

import java.time.LocalDate;
import java.util.List;

public interface CarSellerRelationService {

    DataResult<CarSellerRelationDto> add(CarSellerRelationDto carSellerRelationDto);
    DataResult<List<CarSellerRelationDto>> getAllCar();
    DataResult<CarSellerRelationDto> update(CarSellerRelationDto carSellerRelationDto);
    Result delete(Integer carSellerRelationId);
    DataResult<List<CarSellerRelationDto>> findBySeller_CompanyName(String companyName);
    DataResult<List<CarSellerRelationDto>> filter(CarSellerRelationFilterDto carSellerRelationFilterDto, LocalDate startDate, LocalDate endDate);

}
