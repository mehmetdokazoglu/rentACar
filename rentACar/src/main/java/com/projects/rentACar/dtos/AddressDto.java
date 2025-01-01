package com.projects.rentACar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDto {

    private Integer addressId;
    private CityDto cityDto;
    private DistrictDto districtDto;
    @NotBlank(message = "Lutfen mahalle giriniz")
    private String neighborhood;
    @NotBlank(message = "Lutfen sokak giriniz")
    private String street;
    @NotBlank(message = "Lutfen apartman giriniz")
    private String apartment;
    @NotBlank(message = "Lutfen apartman numaranizi giriniz")
    @Pattern(regexp = "^(\\d{1,3})/(\\d{1})$", message = "Apartman numarasi yalnizca rakamlardan olusmalidir")
    private String apartmentNumber;
    private SellerDto sellerDto;


    public AddressDto(){}

    private AddressDto(Builder builder){

        this.addressId = builder.addressId;
        this.cityDto = builder.cityDto;
        this.districtDto = builder.districtDto;
        this.neighborhood = builder.neighborhood;
        this.street = builder.street;
        this.apartment = builder.apartment;
        this.apartmentNumber = builder.apartmentNumber;
        this.sellerDto = builder.sellerDto;
    }

    public static class Builder{

        private Integer addressId;
        private CityDto cityDto;
        private DistrictDto districtDto;
        private String neighborhood;
        private String street;
        private String apartment;
        private String apartmentNumber;
        private SellerDto sellerDto;

        public Builder(){}

        public Builder(AddressDto addressDto){

            this.addressId = addressDto.addressId;
            this.cityDto = addressDto.cityDto;
            this.districtDto = addressDto.districtDto;
            this.neighborhood = addressDto.neighborhood;
            this.street = addressDto.street;
            this.apartment = addressDto.apartment;
            this.apartmentNumber = addressDto.apartmentNumber;
            this.sellerDto = addressDto.sellerDto;
        }

        public Builder addressId(Integer addressId){
            this.addressId = addressId;
            return this;
        }

        public Builder cityDto(CityDto cityDto){
            this.cityDto = cityDto;
            return this;
        }

        public Builder districtDto(DistrictDto districtDto){
            this.districtDto = districtDto;
            return this;
        }

        public Builder neighborhood(String neighborhood){
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder street(String street){
            this.street = street;
            return this;
        }

        public Builder apartment(String apartment){
            this.apartment = apartment;
            return this;
        }

        public Builder apartmentNumber(String apartmentNumber){
            this.apartmentNumber = apartmentNumber;
            return this;
        }

        public Builder sellerDto(SellerDto sellerDto){
            this.sellerDto = sellerDto;
            return this;
        }


        public AddressDto build(){
            return new AddressDto(this);
        }
    }
}
