package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CityDto;
import com.projects.rentACar.entities.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityDtoMapper {

    public CityDto map(City city){

        return new CityDto.Builder()
                .cityId(city.getCityId())
                .cityDto(city.getCityName())
                .build();
    }

    public List<CityDto> mapList(List<City> cities){
        List<CityDto> cityDtoList = new ArrayList<>();
        for(City city : cities){
            cityDtoList.add(this.map(city));
        }
        return cityDtoList;
    }

    public City convertToEntity(CityDto cityDto){
        City city = new City();
        city.setCityId(cityDto.getCityId());
        city.setCityName(cityDto.getCityName());
        return city;
    }
}
