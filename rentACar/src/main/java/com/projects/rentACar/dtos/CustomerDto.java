package com.projects.rentACar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private Integer customerId;
    private UserDto userDto;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationalIdentity;


    public CustomerDto() {
    }

    private CustomerDto(Builder builder) {

        this.customerId = builder.customerId;
        this.userDto = builder.userDto;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationalIdentity = builder.nationalIdentity;
    }

    public static class Builder {

        private Integer customerId;
        private UserDto userDto;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String nationalIdentity;


        public Builder() {
        }

        public Builder(CustomerDto customerDto) {
            this.customerId = customerDto.customerId;
            this.userDto = customerDto.userDto;
            this.firstName = customerDto.firstName;
            this.lastName = customerDto.lastName;
            this.dateOfBirth = customerDto.dateOfBirth;
            this.nationalIdentity = customerDto.nationalIdentity;
        }

        public Builder customerId(Integer customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder userDto(UserDto userDto){
            this.userDto = userDto;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder nationalIdentity(String nationalIdentity) {
            this.nationalIdentity = nationalIdentity;
            return this;
        }


        public CustomerDto build() {
            return new CustomerDto(this);
        }
    }
}
