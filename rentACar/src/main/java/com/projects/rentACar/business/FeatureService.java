package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.FeatureDto;
import com.projects.rentACar.entities.Feature;

import java.util.List;

public interface FeatureService {

    DataResult<FeatureDto> add(FeatureDto carFeatureDto);
    DataResult<List<FeatureDto>> getAllCar();
    DataResult<FeatureDto> update(FeatureDto carFeatureDto);
    Result delete(Integer featureId);
    DataResult<FeatureDto> findByFeature(String feature);
}
