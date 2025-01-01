package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.DistrictDto;
import com.projects.rentACar.entities.District;

import java.util.List;

public interface DistrictService {

    DataResult<DistrictDto> add(DistrictDto districtDto);
    DataResult<List<DistrictDto>> getAllDistrict();
    DataResult<DistrictDto> update(DistrictDto districtDto);
    Result delete(Integer districtId);
    DataResult<DistrictDto> findByDistrictName(String districtName);
}

