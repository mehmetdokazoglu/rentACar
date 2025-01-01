package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CarDto;

import java.util.List;

public interface CarService {

    DataResult<CarDto> add(CarDto carDto) throws Exception;
    DataResult<List<CarDto>> getAllCar();
    DataResult<CarDto> update(CarDto carDto);
    DataResult<CarDto> findByCarName(String carName);
    Result delete(Integer carId);
}
