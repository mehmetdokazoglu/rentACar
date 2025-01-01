package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.CarFeatureRelationService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.CarFeatureRelationDto;
import com.projects.rentACar.entities.CarFeatureRelation;
import com.projects.rentACar.mapper.CarFeatureRelationDtoMapper;
import com.projects.rentACar.repository.CarFeatureRelationRepository;
import com.projects.rentACar.repository.CarRepository;
import com.projects.rentACar.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarFeatureRelationServiceImplement implements CarFeatureRelationService {

    private final CarFeatureRelationRepository carFeatureRelationRepository;
    private final CarFeatureRelationDtoMapper carFeatureRelationDtoMapper;

    private final CarRepository carRepository;
    private final FeatureRepository featureRepository;

    @Override
    public DataResult<CarFeatureRelationDto> add(CarFeatureRelationDto carFeatureRelationDto) {
        if(carFeatureRelationDto == null || carFeatureRelationDto.getCarDto() == null || carFeatureRelationDto.getFeatureDto() == null){
            return new ErrorDataResult<>(null, "Lütfen istenen alanları doldurunuz");
        }
        if(carRepository.findByCarId(carFeatureRelationDto.getCarDto().getCarId()) == null){
            return new ErrorDataResult<>(null, "Bu araç kaydı sistemde mevcut değil");
        }
        if(featureRepository.findByFeatureId(carFeatureRelationDto.getFeatureDto().getFeatureId()) == null){
            return new ErrorDataResult<>(null, "Bu özellik kaydı sistemde mevcut değil");
        }
        return new SuccessDataResult<>(carFeatureRelationDtoMapper.map(carFeatureRelationRepository.save(carFeatureRelationDtoMapper.convertToEntity(carFeatureRelationDto))), "Araca ozellik eklendi");
    }

    @Override
    public DataResult<List<CarFeatureRelationDto>> getAllCar() {
        return new SuccessDataResult<>(carFeatureRelationDtoMapper.mapList(carFeatureRelationRepository.findAll()), "Arac ozellikleri listelendi");
    }

    @Override
    public DataResult<CarFeatureRelationDto> update(CarFeatureRelationDto carFeatureRelationDto) {
        CarFeatureRelation resultCarFeatureRelation = carFeatureRelationRepository.findByCarFeatureRelationId(carFeatureRelationDto.getCarFeatureRelationId());
        if (resultCarFeatureRelation == null) {
            throw new NullPointerException("Kullanıcı bulunamadı");
        }
        return new SuccessDataResult<>(carFeatureRelationDtoMapper.map(carFeatureRelationRepository.save(carFeatureRelationDtoMapper.convertToEntity(carFeatureRelationDto))));
    }

    @Override
    public Result delete(Integer carFeatureRelationId) {
        if (carFeatureRelationRepository.findByCarFeatureRelationId(carFeatureRelationId) == null) {
            return new ErrorResult("Bu idye sahip bir kayıt bulunamadı");
        }
        carFeatureRelationRepository.deleteById(carFeatureRelationId);
        return new SuccessResult("Araç özelik kaydı başarıyla silindi");
    }
}
