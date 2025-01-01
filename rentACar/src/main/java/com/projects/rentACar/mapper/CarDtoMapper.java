package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CarDto;
import com.projects.rentACar.entities.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDtoMapper {

    public CarDto map(Car car){

        return new CarDto.Builder()
//                .carId(car.getCarId())
                .carName(car.getCarName())
                .vehicleProductionDate(car.getVehicleProductionDate())
                .price(car.getPrice())
                .build();
    }

    public List<CarDto> mapList(List<Car> cars){
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car car : cars){
            carDtoList.add(this.map(car));
        }
        return carDtoList;
    }

    public Car convertToEntity(CarDto carDto){
        Car car = new Car();
        car.setCarId(carDto.getCarId());
        car.setCarName(carDto.getCarName().trim().toUpperCase());
        car.setVehicleProductionDate(carDto.getVehicleProductionDate());
        car.setPrice(carDto.getPrice());
        return car;
    }

    public Car convertToEntityByOnlyId(CarDto carDto){
        Car car = new Car();
        car.setCarId(carDto.getCarId());
        return car;
    }

    public CarDto mapByOnlyWithoutId(Car car){

        return new CarDto.Builder()
                .carName(car.getCarName())
                .vehicleProductionDate(car.getVehicleProductionDate())
                .price(car.getPrice())
                .build();
    }

//    public List<CarDto> mapByOnlyWithoutIdList(List<Car> cars){
//        List<CarDto> carDtoList = new ArrayList<>();
//        for(Car car : cars){
//            carDtoList.add(this.map(car));
//        }
//        return carDtoList;
//    }
//
//    public Car convertToEntityWitByOnlyWithoutId(CarDto carDto){
//        Car car = new Car();
//        car.setCarName(carDto.getCarName());
//        car.setVehicleProductionDate(carDto.getVehicleProductionDate());
//        car.setPrice(carDto.getPrice());
//        return car;
//    }
}
