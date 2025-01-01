package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CityDto;
import com.projects.rentACar.entities.City;

import java.util.List;

public interface CityService {

    DataResult<CityDto> add(CityDto cityDto);
    DataResult<List<CityDto>> getAllCity();
    DataResult<CityDto> update(CityDto cityDto);
    Result delete(Integer cityId);
    DataResult<CityDto> findByCityName(String cityName);
}
