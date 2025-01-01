package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CarSellerRelationDto;
import com.projects.rentACar.entities.CarSellerRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarSellerRelationDtoMapper {

    @Autowired
    private SellerFilterDtoMapper sellerFilterDtoMapper;

    public CarSellerRelationDto map(CarSellerRelation carSellerRelation){

        return new CarSellerRelationDto.Builder()
                .carSellerRelationId(carSellerRelation.getCarSellerRelationId())
                .carDto(new CarDtoMapper().map(carSellerRelation.getCar()))
                .sellerFilterDto(sellerFilterDtoMapper.map(carSellerRelation.getSeller()))
                .build();
    }

    public List<CarSellerRelationDto> mapList(List<CarSellerRelation> carSellerRelations){
        List<CarSellerRelationDto> carSellerRelationDtoList = new ArrayList<>();
        for(CarSellerRelation carSellerRelation : carSellerRelations){
            carSellerRelationDtoList.add(this.map(carSellerRelation));
        }
        return carSellerRelationDtoList;
    }

    public CarSellerRelation convertToEntity(CarSellerRelationDto carSellerRelationDto){
        CarSellerRelation carSellerRelation = new CarSellerRelation();
        carSellerRelation.setCarSellerRelationId(carSellerRelationDto.getCarSellerRelationId());
        carSellerRelation.setCar(new CarDtoMapper().convertToEntityByOnlyId(carSellerRelationDto.getCarDto()));
        carSellerRelation.setSeller(sellerFilterDtoMapper.convertToEntityByOnlyId(carSellerRelationDto.getSellerFilterDto()));
        return carSellerRelation;
    }
}
