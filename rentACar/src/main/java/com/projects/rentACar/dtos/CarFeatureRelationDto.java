package com.projects.rentACar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarFeatureRelationDto {

    private Integer carFeatureRelationId;
    private CarDto carDto;
    private FeatureDto featureDto;

    public CarFeatureRelationDto(){}

    private CarFeatureRelationDto(Builder builder){
        this.carFeatureRelationId = builder.carFeatureRelationId;
        this.carDto = builder.carDto;
        this.featureDto = builder.featureDto;
    }

    public static class Builder{

        private Integer carFeatureRelationId;
        private CarDto carDto;
        private FeatureDto featureDto;

        public Builder(){}

        public Builder(CarFeatureRelationDto carFeatureRelationDto){
            this.carFeatureRelationId = carFeatureRelationDto.carFeatureRelationId;
            this.carDto = carFeatureRelationDto.carDto;
            this.featureDto = carFeatureRelationDto.featureDto;
        }

        public Builder carFeatureRelationId(Integer carFeatureRelationId){
            this.carFeatureRelationId = carFeatureRelationId;
            return this;
        }

        public Builder carDto(CarDto carDto){
            this.carDto = carDto;
            return this;
        }

        public Builder featureDto(FeatureDto featureDto){
            this.featureDto = featureDto;
            return this;
        }

        public CarFeatureRelationDto build(){
            return new CarFeatureRelationDto(this);
        }
    }
}
