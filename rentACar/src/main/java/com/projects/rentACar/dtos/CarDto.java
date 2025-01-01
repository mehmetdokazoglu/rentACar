package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CarDto {

    private Integer carId;
    private String carName;
    private LocalDate vehicleProductionDate;
    private double price;

    public CarDto() {

    }

    private CarDto(Builder builder) {
        this.carId = builder.carId;
        this.carName = builder.carName;
        this.vehicleProductionDate = builder.vehicleProductionDate;
        this.price = builder.price;
    }

    public static class Builder {
        private Integer carId;
        private String carName;
        private LocalDate vehicleProductionDate;
        private double price;


        public Builder(){

        }

        public Builder(CarDto carDto) {
            this.carId = carDto.carId;
            this.carName = carDto.carName;
            this.vehicleProductionDate = carDto.vehicleProductionDate;
            this.price = carDto.price;
        }

        public Builder carId(Integer carId) {
            this.carId = carId;
            return this;
        }

        public Builder carName(String carName) {
            this.carName = carName;
            return this;
        }

        public Builder vehicleProductionDate(LocalDate vehicleProductionDate) {
            this.vehicleProductionDate = vehicleProductionDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public CarDto build() {
            return new CarDto(this);
        }
    }
}
