package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarSellerRelationFilterDto {

    private CarFilterDto carFilterDto;
    private SellerFilterDto sellerFilterDto;

    public CarSellerRelationFilterDto(){}

    private CarSellerRelationFilterDto(Builder builder){

        this.carFilterDto = builder.carFilterDto;
        this.sellerFilterDto = builder.sellerFilterDto;
    }

    public static class Builder{

        private CarFilterDto carFilterDto;
        private SellerFilterDto sellerFilterDto;

        public Builder(){}

        public Builder(CarSellerRelationFilterDto carSellerRelationFilterDto){

            this.carFilterDto = carSellerRelationFilterDto.carFilterDto;
            this.sellerFilterDto = carSellerRelationFilterDto.sellerFilterDto;
        }

        public Builder carFilterDto(CarFilterDto carFilterDto){
            this.carFilterDto = carFilterDto;
            return this;
        }

        public Builder sellerFilterDto(SellerFilterDto sellerFilterDto){
            this.sellerFilterDto = sellerFilterDto;
            return this;
        }
    }
}
