package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CustomerFilterDto {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public CustomerFilterDto(){}

    private CustomerFilterDto(Builder builder){

        this.customerId = builder.customerId;
        this.firstName = builder.firstName;;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public static class Builder{

        private Integer customerId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;


        public Builder(){}

        public Builder(CustomerFilterDto customerFilterDto){

            this.customerId = customerFilterDto.customerId;
            this.firstName = customerFilterDto.firstName;
            this.lastName = customerFilterDto.lastName;
            this.dateOfBirth = customerFilterDto.dateOfBirth;
        }

        public Builder customerId(Integer customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public CustomerFilterDto build(){
            return new CustomerFilterDto(this);
        }
    }
}
