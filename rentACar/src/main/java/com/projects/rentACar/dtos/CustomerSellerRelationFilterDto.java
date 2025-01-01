package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerSellerRelationFilterDto {

    private CustomerFilterDto customerFilterDto;
    private SellerFilterDto sellerFilterDto;
    private UserFilterDto userFilterDto;

    public CustomerSellerRelationFilterDto(){}

    private CustomerSellerRelationFilterDto(Builder builder){

        this.customerFilterDto = builder.customerFilterDto;
        this.sellerFilterDto = builder.sellerFilterDto;
        this.userFilterDto = builder.userFilterDto;
    }

    public static class Builder{

        private CustomerFilterDto customerFilterDto;
        private SellerFilterDto sellerFilterDto;
        private UserFilterDto userFilterDto;


        public Builder(){}

        public Builder(CustomerSellerRelationFilterDto customerSellerRelationFilterDto){

            this.customerFilterDto = customerSellerRelationFilterDto.customerFilterDto;
            this.sellerFilterDto = customerSellerRelationFilterDto.sellerFilterDto;
            this.userFilterDto = customerSellerRelationFilterDto.userFilterDto;
        }

        public Builder customerFilterDto(CustomerFilterDto customerFilterDto){
            this.customerFilterDto = customerFilterDto;
            return this;
        }

        public Builder sellerFilterDto(SellerFilterDto sellerFilterDto){
            this.sellerFilterDto= sellerFilterDto;
            return this;
        }

        public Builder userFilterDto(UserFilterDto userFilterDto){
            this.userFilterDto = userFilterDto;
            return this;
        }

        public CustomerSellerRelationFilterDto build(){
            return new CustomerSellerRelationFilterDto(this);
        }
    }

}
