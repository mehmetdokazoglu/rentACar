package com.projects.rentACar.dtos;

import com.projects.rentACar.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DistrictDto {

    private Integer districtId;
    @NotBlank(message = "Lutfen ilce adı giriniz")
    @Pattern(regexp = "^[a-zA-ZğĞıİçÇşŞöÖ]+$", message = "Ilce adı yalnızca harflerden olusmalidir")
    private String districtName;

    public DistrictDto() {}

    private DistrictDto(Builder builder) {

        this.districtId = builder.districtId;
        this.districtName = builder.districtName;
    }

    public static class Builder {

        private Integer districtId;
        private String districtName;
        private List<AddressDto> addressDtos;

        public Builder(){}

        public Builder(DistrictDto districtDto) {

            this.districtId = districtDto.districtId;
            this.districtName = districtDto.districtName;
        }

        public Builder districtId(Integer districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder districtName(String districtName) {
            this.districtName = districtName;
            return this;
        }

        public DistrictDto build(){
            return new DistrictDto(this);
        }
    }
}
