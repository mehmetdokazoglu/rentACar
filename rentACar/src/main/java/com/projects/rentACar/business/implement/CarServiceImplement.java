package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.CarService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.CarDto;
import com.projects.rentACar.entities.Car;
import com.projects.rentACar.mapper.CarDtoMapper;
import com.projects.rentACar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImplement implements CarService {

    private final CarRepository carRepository;
    private final CarDtoMapper carDtoMapper;

    @Override
    public DataResult<CarDto> add(CarDto carDto) throws Exception {
        if(carDto == null){
            return new ErrorDataResult<>(null, "İstenen bilgileri doldurunuz");
        }
        if(carDto.getCarName() == null || carDto.getCarName().isEmpty()){
            return new ErrorDataResult<>(null, "Araç adını giriniz");
        }
        if(carDto.getPrice() < 500){
            return new ErrorDataResult<>(null, "Araç kiralama fiyatı minimum fiyatın altında olamaz.(500)");
        }
        return new SuccessDataResult<>(carDtoMapper.map(carRepository.save(carDtoMapper.convertToEntity(carDto))),"Araç eklendi");
    }

    @Override
    public DataResult<List<CarDto>> getAllCar() {
        return new SuccessDataResult<>(carDtoMapper.mapList(carRepository.findAll()),"Araçlar listelendi");
    }

    @Override
    public DataResult<CarDto> update(CarDto carDto) {
        if(carDto == null){
            throw new IllegalArgumentException("Lütfen güncellemek istediğiniz alanları doldurunuz");
        }
        Car resultCar = carRepository.findByCarId(carDto.getCarId());
        if(resultCar == null){
            throw new NullPointerException("Araç bulunamadı");
        }
        return new SuccessDataResult<>(carDtoMapper.map(carRepository.save(carDtoMapper.convertToEntity(carDto))),"Araçlar güncellendi");
    }

    @Override
    public DataResult<CarDto> findByCarName(String carName) {
        return new SuccessDataResult<>(carDtoMapper.map(carRepository.findByCarName(carName)));
    }

    @Override
    public Result delete(Integer carId) {
        if(carId == null){
            throw new IllegalArgumentException("Lütfen silmek istediğiniz aracın id'sini girin");
        }
        Car car = carRepository.findByCarId(carId);
        if(car == null){
            throw new IllegalArgumentException("Bu id'ye sahip bir araç bulunamadı");
        }
        carRepository.deleteById(carId);
        return new SuccessResult("Araç başarıyla silindi");
    }
}
