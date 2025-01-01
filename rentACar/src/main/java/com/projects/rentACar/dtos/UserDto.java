package com.projects.rentACar.dtos;

import com.projects.rentACar.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Role role;

    public UserDto(){}

    private UserDto(Builder builder){

        this.userId = builder.userId;
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;;
        this.role = builder.role;
    }

    public static class Builder{

        private Integer userId;
        private String userName;
        private String email;
        private String password;
        private Role role;

        public Builder(){}

        public Builder(UserDto userDto){

            this.userId = userDto.userId;
            this.userName = userDto.userName;
            this.email = userDto.email;
            this.password = userDto.password;
            this.role = userDto.role;
        }

        public Builder userId(Integer userId){
            this.userId = userId;
            return this;
        }


        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }


        public UserDto build(){
            return new UserDto(this);
        }
    }
}
