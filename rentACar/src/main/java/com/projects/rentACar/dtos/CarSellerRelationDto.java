package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarSellerRelationDto {

    private Integer carSellerRelationId;
    private CarDto carDto;
    private SellerFilterDto sellerFilterDto;

    public CarSellerRelationDto(){}

    private CarSellerRelationDto(Builder builder){

        this.carSellerRelationId = builder.carSellerRelationId;;
        this.carDto = builder.carDto;
        this.sellerFilterDto = builder.sellerFilterDto;
    }

    public static class Builder{

        private Integer carSellerRelationId;
        private CarDto carDto;
        private SellerFilterDto sellerFilterDto;

        public Builder(){}

        public Builder(CarSellerRelationDto carSellerRelationDto){
            this.carSellerRelationId = carSellerRelationDto.carSellerRelationId;
            this.carDto = carSellerRelationDto.carDto;
            this.sellerFilterDto = carSellerRelationDto.sellerFilterDto;
        }

        public Builder carSellerRelationId(Integer carSellerRelationId){
            this.carSellerRelationId = carSellerRelationId;
            return this;
        }

        public Builder carDto(CarDto carDto){
            this.carDto = carDto;
            return this;
        }

        public Builder sellerFilterDto(SellerFilterDto sellerFilterDto){
            this.sellerFilterDto = sellerFilterDto;
            return this;
        }

        public CarSellerRelationDto build(){
            return new CarSellerRelationDto(this);
        }
    }
}
