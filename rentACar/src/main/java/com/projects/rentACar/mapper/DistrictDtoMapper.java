package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.DistrictDto;
import com.projects.rentACar.entities.District;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistrictDtoMapper {

    public DistrictDto map(District district){

        return new DistrictDto.Builder()
                .districtId(district.getDistrictId())
                .districtName(district.getDistrictName())
                .build();
    }

    public List<DistrictDto> mapList(List<District> districts){
        List<DistrictDto> districtDtoList = new ArrayList<>();
        for(District district : districts){
            districtDtoList.add(this.map(district));
        }
        return districtDtoList;
    }

    public District convertToEntity(DistrictDto districtDto){
        District district = new District();
        district.setDistrictId(districtDto.getDistrictId());
        district.setDistrictName(districtDto.getDistrictName().trim().toUpperCase());
        return district;
    }
}
