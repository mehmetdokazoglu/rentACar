package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.CarSellerRelationService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.CarSellerRelationDto;
import com.projects.rentACar.dtos.CarSellerRelationFilterDto;
import com.projects.rentACar.entities.CarSellerRelation;
import com.projects.rentACar.mapper.CarSellerRelationDtoMapper;
import com.projects.rentACar.repository.CarRepository;
import com.projects.rentACar.repository.CarSellerRelationRepository;
import com.projects.rentACar.repository.SellerRepository;
import com.projects.rentACar.specification.CarSellerRelationSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarSellerRelationServiceImplement implements CarSellerRelationService {

    private final CarSellerRelationRepository carSellerRelationRepository;
    private final CarSellerRelationDtoMapper carSellerRelationDtoMapper;

    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;

    @Override
    public DataResult<CarSellerRelationDto> add(CarSellerRelationDto carSellerRelationDto) {
        if (carSellerRelationDto == null || carSellerRelationDto.getCarDto() == null || carSellerRelationDto.getSellerFilterDto() == null) {
            return new ErrorDataResult<>(null, "Lütfen istenen alanlaro doldurunuz");
        }
        if (carRepository.findByCarId(carSellerRelationDto.getCarDto().getCarId()) == null) {
            return new ErrorDataResult<>(null, "Bu araç kaydı sistemde mevcut değil");
        }
        if (sellerRepository.findBySellerId(carSellerRelationDto.getSellerFilterDto().getSellerId()) == null) {
            return new ErrorDataResult<>(null, "Bu satıcı kaydı sistemde mevcut değil");
        }
        return new SuccessDataResult<>
                (carSellerRelationDtoMapper.map(carSellerRelationRepository.save(carSellerRelationDtoMapper.convertToEntity(carSellerRelationDto))), "Araç firma kaydı eklendi");
    }

    @Override
    public DataResult<List<CarSellerRelationDto>> getAllCar() {
        return new SuccessDataResult<>(carSellerRelationDtoMapper.mapList(carSellerRelationRepository.findAll()), "Araç firma kayıtları listelendi");
    }

    @Override
    public DataResult<CarSellerRelationDto> update(CarSellerRelationDto carSellerRelationDto) {
        CarSellerRelation resultCarSellerRelation = carSellerRelationRepository.findByCarSellerRelationId(carSellerRelationDto.getCarSellerRelationId());
        if (resultCarSellerRelation == null) {
            throw new NullPointerException("Kullanıcı bulunamadı");
        }
        return new SuccessDataResult<>(carSellerRelationDtoMapper.map(carSellerRelationRepository.save(carSellerRelationDtoMapper.convertToEntity(carSellerRelationDto))));
    }

    @Override
    public Result delete(Integer carSellerRelationId) {
        CarSellerRelation carSellerRelation = carSellerRelationRepository.findByCarSellerRelationId(carSellerRelationId);
        if (carSellerRelation == null) {
            return new ErrorResult("Bu idye sahip kayıt bulunamadı");
        }
        carSellerRelationRepository.deleteById(carSellerRelationId);
        return new SuccessResult("Araç firma kaydı başarıyla silindi");
    }

    @Override
    public DataResult<List<CarSellerRelationDto>> findBySeller_CompanyName(String companyName) {
        return new SuccessDataResult<>(carSellerRelationDtoMapper.mapList(carSellerRelationRepository.findBySeller_CompanyName(companyName)));
    }

    @Override
    public DataResult<List<CarSellerRelationDto>> filter(CarSellerRelationFilterDto carSellerRelationFilterDto, LocalDate startDate, LocalDate endDate) {
        List<CarSellerRelation> carSellerRelations = carSellerRelationRepository.findAll(
                CarSellerRelationSpecification.filterBySpecification(carSellerRelationFilterDto, startDate, endDate));
        if (carSellerRelations.isEmpty()) {
            return new ErrorDataResult<>(null, "Böyle bir kayıt sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(carSellerRelationDtoMapper.mapList(carSellerRelations));
    }
}
