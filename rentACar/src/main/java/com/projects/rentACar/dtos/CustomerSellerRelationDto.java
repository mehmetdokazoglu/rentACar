package com.projects.rentACar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSellerRelationDto {

    private Integer customerSellerRelationId;
    private CustomerFilterDto customerFilterDto;
    private SellerFilterDto sellerFilterDto;

    public CustomerSellerRelationDto(){}


    private CustomerSellerRelationDto(Builder builder){

        this.customerSellerRelationId = builder.customerSellerRelationId;
        this.customerFilterDto = builder.customerFilterDto;
        this.sellerFilterDto = builder.sellerFilterDto;
    }

    public static class Builder{

        private Integer customerSellerRelationId;
        private CustomerFilterDto customerFilterDto;
        private SellerFilterDto sellerFilterDto;


        public Builder(){}

        public Builder(CustomerSellerRelationDto customerSellerRelationDto){

            this.customerSellerRelationId = customerSellerRelationDto.getCustomerSellerRelationId();
            this.customerFilterDto = customerSellerRelationDto.getCustomerFilterDto();
            this.sellerFilterDto = customerSellerRelationDto.getSellerFilterDto();
        }

        public Builder customerSellerRelationId(Integer customerSellerRelationId){
            this.customerSellerRelationId = customerSellerRelationId;
            return this;
        }

        public Builder customerFilterDto(CustomerFilterDto customerFilterDto){
            this.customerFilterDto = customerFilterDto;
            return this;
        }

        public Builder sellerFilterDto(SellerFilterDto sellerFilterDto){
            this.sellerFilterDto = sellerFilterDto;
            return this;
        }

        public CustomerSellerRelationDto build(){
            return new CustomerSellerRelationDto(this);
        }
    }
}
