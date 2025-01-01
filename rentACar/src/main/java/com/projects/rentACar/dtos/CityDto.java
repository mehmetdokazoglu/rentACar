package com.projects.rentACar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CityDto {

    private Integer cityId;
    @NotBlank(message = "Lutfen sehir adi giriniz")
    @Pattern(regexp = "^[a-zA-ZğĞıİçÇşŞöÖ]+$", message = "Sehir adi yalnizca harflerden olusmalidir")
    private String cityName;

    public CityDto() {}


    private CityDto(Builder builder) {

        this.cityId = builder.cityId;
        this.cityName = builder.cityName;
    }

    public static class Builder {

        private Integer cityId;
        private String cityName;

        public Builder(){}

        public Builder(CityDto cityDto) {

            this.cityId = cityDto.cityId;
            this.cityName = cityDto.cityName;
        }

        public Builder cityId(Integer cityId) {
            this.cityId = cityId;
            return this;
        }

        public Builder cityDto(String cityName) {
            this.cityName = cityName;
            return this;
        }


        public CityDto build(){
            return new CityDto(this);
        }
    }
}
