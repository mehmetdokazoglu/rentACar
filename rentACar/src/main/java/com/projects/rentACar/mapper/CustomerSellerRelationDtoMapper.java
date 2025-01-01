package com.projects.rentACar.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.dtos.CustomerSellerRelationDto;
import com.projects.rentACar.entities.Customer;
import com.projects.rentACar.entities.CustomerSellerRelation;
import com.projects.rentACar.entities.Seller;
import com.projects.rentACar.repository.CustomerRepository;
import com.projects.rentACar.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerSellerRelationDtoMapper {

    @Autowired
    private CustomerDtoFilterMapper customerRelationDtoMapper;

    private final CustomerRepository customerRepository;

    private final SellerRepository sellerRepository;

    @Autowired
    private SellerDtoFilterMapper sellerDtoFilterMapper;

    public CustomerSellerRelationDto map(CustomerSellerRelation customerSellerRelation){

        return new CustomerSellerRelationDto.Builder()
                .customerSellerRelationId(customerSellerRelation.getCustomerSellerRelationId())
                .customerFilterDto(customerRelationDtoMapper.map(customerSellerRelation.getCustomer()))
                .sellerFilterDto(sellerDtoFilterMapper.map(customerSellerRelation.getSeller()))
                .build();
    }

    public List<CustomerSellerRelationDto> mapList(List<CustomerSellerRelation> customerSellerRelations){
        List<CustomerSellerRelationDto> customerSellerRelationDtoList = new ArrayList<>();
        for(CustomerSellerRelation customerSellerRelation : customerSellerRelations){
            customerSellerRelationDtoList.add(this.map(customerSellerRelation));
        }
        return customerSellerRelationDtoList;
    }

    public CustomerSellerRelation convertToEntity(CustomerSellerRelationDto customerSellerRelationDto){
        
        CustomerSellerRelation customerSellerRelation = new CustomerSellerRelation();
        customerSellerRelation.setCustomerSellerRelationId(customerSellerRelationDto.getCustomerSellerRelationId());
        customerSellerRelation.setCustomer(customerRelationDtoMapper.convertToEntityByOnlyId(customerSellerRelationDto.getCustomerFilterDto()));
        customerSellerRelation.setSeller(sellerDtoFilterMapper.convertToEntityByOnlyId(customerSellerRelationDto.getSellerFilterDto()));
        return customerSellerRelation;
    }
}
