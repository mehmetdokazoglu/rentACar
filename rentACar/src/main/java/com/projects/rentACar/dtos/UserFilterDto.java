package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserFilterDto {

    private String userName;
    private String email;

    public UserFilterDto(){}

    private UserFilterDto(Builder builder){

        this.userName = builder.userName;
        this.email = builder.email;
    }

    public static class Builder{

        private String userName;
        private String email;

        public Builder(){}

        public Builder(UserFilterDto userFilterDto){

            this.userName = userFilterDto.userName;
            this.email = userFilterDto.email;
        }

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public UserFilterDto build(){
            return new UserFilterDto(this);
        }
    }
}
