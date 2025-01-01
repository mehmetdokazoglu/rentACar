package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CarFilterDto {

    private String carName;
    private LocalDate vehicleProductionDate;
    private double price;

    public CarFilterDto(){}

    private CarFilterDto(Builder builder){

        this.carName = builder.carName;
        this.vehicleProductionDate = builder.vehicleProductionDate;
        this.price = builder.price;
    }

    public static class Builder{

        private String carName;
        private LocalDate vehicleProductionDate;
        private double price;

        public Builder(){}

        public Builder(CarFilterDto carFilterDto){

            this.carName = carFilterDto.carName;
            this.vehicleProductionDate = carFilterDto.vehicleProductionDate;
            this.price = carFilterDto.price;
        }

        public Builder carName(String carName){
            this.carName = carName;
            return this;
        }

        public Builder vehicleProductionDate(LocalDate vehicleProductionDate){
            this.vehicleProductionDate = vehicleProductionDate;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public CarFilterDto build(){
            return new CarFilterDto(this);
        }
    }
}
