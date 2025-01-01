package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.AddressDto;
import com.projects.rentACar.entities.Address;

import java.util.List;

public interface AddressService {
    DataResult<AddressDto> add(AddressDto addressDto);

    DataResult<List<AddressDto>> getAllAddress();

    DataResult<AddressDto> update(AddressDto addressDto);

    Result delete(Integer addressId);

    DataResult<AddressDto> findByAddressId(Integer addressId);
}
