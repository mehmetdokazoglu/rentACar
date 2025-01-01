package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CarFeatureRelationDto;
import com.projects.rentACar.entities.CarFeatureRelation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarFeatureRelationDtoMapper {

    public CarFeatureRelationDto map(CarFeatureRelation carFeatureRelation){

        return new CarFeatureRelationDto.Builder()
                .carFeatureRelationId(carFeatureRelation.getCarFeatureRelationId())
                .carDto(new CarDtoMapper().map(carFeatureRelation.getCar()))
                .featureDto(new FeatureDtoMapper().map(carFeatureRelation.getFeature()))
                .build();
    }

    public List<CarFeatureRelationDto> mapList(List<CarFeatureRelation> carFeatureRelations){
        List<CarFeatureRelationDto> carFeatureRelationDtoList = new ArrayList<>();
        for(CarFeatureRelation carFeatureRelation : carFeatureRelations){
            carFeatureRelationDtoList.add(this.map(carFeatureRelation));
        }
        return carFeatureRelationDtoList;
    }

    public CarFeatureRelation convertToEntity(CarFeatureRelationDto carFeatureRelationDto){
        CarFeatureRelation carFeatureRelation = new CarFeatureRelation();
        carFeatureRelation.setCarFeatureRelationId(carFeatureRelationDto.getCarFeatureRelationId());
        carFeatureRelation.setCar(new CarDtoMapper().convertToEntity(carFeatureRelationDto.getCarDto()));
        carFeatureRelation.setFeature(new FeatureDtoMapper().convertToEntity(carFeatureRelationDto.getFeatureDto()));
        return carFeatureRelation;
    }
}
