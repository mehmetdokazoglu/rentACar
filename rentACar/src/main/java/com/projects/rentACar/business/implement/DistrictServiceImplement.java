package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.DistrictService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.DistrictDto;
import com.projects.rentACar.entities.District;
import com.projects.rentACar.mapper.DistrictDtoMapper;
import com.projects.rentACar.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImplement implements DistrictService {

    private final DistrictRepository districtRepository;
    private final DistrictDtoMapper districtDtoMapper;


    @Override
    public DataResult<DistrictDto> add(DistrictDto districtDto) {

        if(districtRepository.findByDistrictName(districtDto.getDistrictName()) != null){
            return new ErrorDataResult<>(null, "Bu ilce zaten kayitli");
        }
        return new SuccessDataResult<>(districtDtoMapper.map(districtRepository.save(districtDtoMapper.convertToEntity(districtDto))), "İlçe eklendi");
    }

    @Override
    public DataResult<List<DistrictDto>> getAllDistrict() {
        return new SuccessDataResult<>(districtDtoMapper.mapList(districtRepository.findAll()),"İlçeler listelendi");
    }

    @Override
    public DataResult<DistrictDto> update(DistrictDto districtDto) {
        District resultDistrict = districtRepository.findByDistrictId(districtDto.getDistrictId());
        if(resultDistrict == null){
            throw new NullPointerException("İlçe bulunamadı");
        }
        return new SuccessDataResult<>(districtDtoMapper.map(districtRepository.save(districtDtoMapper.convertToEntity(districtDto))), "İlçe güncellendi");
    }

    @Override
    public Result delete(Integer districtId) {

        if(districtId == null){
            return new ErrorResult("Lütfen bir id giriniz");
        }if(districtRepository.findByDistrictId(districtId) == null){
            return new ErrorResult("Bu idye sahip bir ilçe bulunamadı");
        }
        districtRepository.deleteById(districtId);
        return new SuccessResult("İlçe başarıyla silindi");
    }

    @Override
    public DataResult<DistrictDto> findByDistrictName(String districtName) {
        District district = districtRepository.findByDistrictName(districtName);
        if(district == null){
            return new ErrorDataResult<>(null, "Şehir sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(districtDtoMapper.map(districtRepository.findByDistrictName(districtName)), "Data getirildi");
    }
}
