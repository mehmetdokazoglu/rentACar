package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.AddressService;
import com.projects.rentACar.business.CityService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.CityDto;
import com.projects.rentACar.entities.City;
import com.projects.rentACar.mapper.CityDtoMapper;
import com.projects.rentACar.repository.AddressRepository;
import com.projects.rentACar.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImplement implements CityService {

    private final CityRepository cityRepository;
    private final CityDtoMapper cityDtoMapper;

    @Override
    public DataResult<CityDto> add(CityDto cityDto) {
        if(cityRepository.findByCityName(cityDto.getCityName()) != null){
            return new ErrorDataResult<>(null, "Bu sehir zaten kayitli");
        }
        return new SuccessDataResult<>(cityDtoMapper.map(cityRepository.save(cityDtoMapper.convertToEntity(cityDto))), "Şehir eklendi");
    }

    @Override
    public DataResult<List<CityDto>> getAllCity() {
        return new SuccessDataResult<>(cityDtoMapper.mapList(cityRepository.findAll()), "Şehirler listelendi");
    }

    @Override
    public DataResult<CityDto> update(CityDto cityDto) {
        City resultCity = cityRepository.findByCityId(cityDto.getCityId());
        if (resultCity == null) {
            throw new NullPointerException("Kullanıcı bulunamadı");
        }
        return new SuccessDataResult<>(cityDtoMapper.map(cityRepository.save(cityDtoMapper.convertToEntity(cityDto))), "Şehir güncellendi");
    }

    @Override
    public Result delete(Integer cityId) {
        if (cityId == null) {
            return new ErrorResult("Lütfen bir id giriniz");
        }
        City city = cityRepository.findByCityId(cityId);
        if (city == null) {
            return new ErrorResult("Bu idye sahip şehir bulunmuyor");
        }
        cityRepository.delete(city);
        return new SuccessResult("Şehir başarıyla silindi");
    }

    @Override
    public DataResult<CityDto> findByCityName(String cityName) {
        City city = cityRepository.findByCityName(cityName);
        if(city == null){
            return new ErrorDataResult<>(null, "Şehir sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(cityDtoMapper.map(cityRepository.findByCityName(cityName)), "Data getirildi");
    }

}
