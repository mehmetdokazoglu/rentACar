package com.projects.rentACar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellerDto {

    private Integer sellerId;
    private UserDto userDto;
    private String companyName;
    private String phoneNumber;

    public SellerDto() {
    }

    private SellerDto(Builder builder) {

        this.sellerId = builder.sellerId;
        this.userDto = builder.userDto;
        this.companyName = builder.companyName;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {

        private Integer sellerId;
        private UserDto userDto;
        private String companyName;
        private String phoneNumber;

        public Builder() {
        }

        public Builder(SellerDto sellerDto) {

            this.sellerId = sellerDto.sellerId;
            this.userDto = sellerDto.userDto;
            this.companyName = sellerDto.companyName;
            this.phoneNumber = sellerDto.phoneNumber;
        }

        public Builder sellerId(Integer sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder userDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }


        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SellerDto build() {
            return new SellerDto(this);
        }
    }
}
