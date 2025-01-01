package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.Seller;
import jakarta.validation.ConstraintViolationException;

import java.util.List;

public interface SellerService {

    DataResult<SellerDto> register(SellerDto sellerDto);
    DataResult<List<SellerDto>> getAllSeller();
    DataResult<SellerDto> update(SellerDto sellerDto);
    Result delete(Integer sellerId);
    String verify(UserDto userDto);
    DataResult<SellerDto> findByCompanyName(String companyName);
}
