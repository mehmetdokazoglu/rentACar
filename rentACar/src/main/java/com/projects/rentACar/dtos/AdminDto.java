package com.projects.rentACar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AdminDto {

    private Integer adminId;

    private UserDto userDto;

    @NotBlank(message = "Lutfen adinizi giriniz")
    @Pattern(regexp = "^[a-zA-ZğĞıİçÇşŞöÖ]+$", message = "Adinizi harf olarak giriniz")
    private String firstName;

    @NotBlank(message = "Lutfen soyadinizi giriniz")
    @Pattern(regexp = "^[a-zA-ZğĞıİçÇşŞöÖ]+$", message = "Soyadinizi harf olarak giriniz")
    private String lastName;


    public AdminDto() {
    }

    private AdminDto(Builder builder) {

        this.adminId = builder.adminId;
        this.userDto = builder.userDto;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder {

        private Integer adminId;
        private UserDto userDto;
        private String firstName;
        private String lastName;


        public Builder() {
        }

        public Builder(AdminDto adminDto) {

            this.adminId = adminDto.adminId;
            this.userDto = adminDto.userDto;
            this.firstName = adminDto.firstName;
            this.lastName = adminDto.lastName;
        }

        public Builder adminId(Integer adminId) {
            this.adminId = adminId;
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

        public AdminDto build() {
            return new AdminDto(this);
        }
    }
}
