package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarFeatureRelationDto;

import java.util.List;

public interface CarFeatureRelationService {

    DataResult<CarFeatureRelationDto> add(CarFeatureRelationDto carFeatureRelationDto);
    DataResult<List<CarFeatureRelationDto>> getAllCar();
    DataResult<CarFeatureRelationDto> update(CarFeatureRelationDto carFeatureRelationDto);
    Result delete(Integer carFeatureRelationId);
}
