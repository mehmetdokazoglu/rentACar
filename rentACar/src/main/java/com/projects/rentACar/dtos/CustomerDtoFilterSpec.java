package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDtoFilterSpec {

    private String firstName;
    private String lastName;
    private UserFilterDto userFilterDto;

    public CustomerDtoFilterSpec(){}

    private CustomerDtoFilterSpec(Builder builder){

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.userFilterDto = builder.userFilterDto;
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private UserFilterDto userFilterDto;

        public Builder(){}

        public Builder(CustomerDtoFilterSpec customerDtoFilterSpec){

            this.firstName = customerDtoFilterSpec.firstName;
            this.lastName = customerDtoFilterSpec.lastName;
            this.userFilterDto = customerDtoFilterSpec.userFilterDto;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder userFilterDto(UserFilterDto userFilterDto){
            this.userFilterDto= userFilterDto;
            return this;
        }
    }
}
