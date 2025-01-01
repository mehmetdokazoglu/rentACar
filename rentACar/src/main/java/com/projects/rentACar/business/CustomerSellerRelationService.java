package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.dtos.CustomerSellerRelationDto;
import com.projects.rentACar.dtos.CustomerSellerRelationFilterDto;

import java.util.List;

public interface CustomerSellerRelationService {

    DataResult<CustomerSellerRelationDto> add(CustomerSellerRelationDto customerSellerRelationDto);

    DataResult<List<CustomerSellerRelationDto>> getAllRelation();

    DataResult<List<CustomerSellerRelationDto>> filter(CustomerSellerRelationFilterDto customerSellerRelationFilterDto);
}
