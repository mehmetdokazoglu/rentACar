package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.AddressService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.AddressDto;
import com.projects.rentACar.entities.Address;
import com.projects.rentACar.mapper.AddressDtoMapper;
import com.projects.rentACar.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImplement implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressDtoMapper addressDtoMapper;

    @Override
    public DataResult<AddressDto> add(AddressDto addressDto) {
        if (addressDto == null) {
            return new ErrorDataResult<>(null, "Boş veri gönderilemez");
        }if(addressRepository.findByApartmentNumber(addressDto.getApartmentNumber()) != null){
            return new ErrorDataResult<>(null, "Bu adrese ait bir kullanici sistemde kayitli");
        }
        return new SuccessDataResult<>(addressDtoMapper.map(addressRepository.save(addressDtoMapper.convertToEntity(addressDto))));
    }

    @Override
    public DataResult<List<AddressDto>> getAllAddress() {
        return new SuccessDataResult<>(addressDtoMapper.mapList(addressRepository.findAll()), "Adresler listelendi");
    }

    @Override
    public DataResult<AddressDto> update(AddressDto addressDto) {
        Address resultAddress = addressRepository.findByAddressId(addressDto.getAddressId());
        if (resultAddress == null) {
            return new ErrorDataResult<>(null, "Böyle bir adres sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(addressDtoMapper.map(addressRepository.save(addressDtoMapper.convertToEntity(addressDto))));
    }

    @Override
    public Result delete(Integer addressId) {

        if (addressRepository.findByAddressId(addressId) == null) {
            return new ErrorResult("Bu idye sahip adres bulunamadı");
        }
        addressRepository.deleteById(addressId);
        return new SuccessResult("Adres başarıyla silindi");
    }

    @Override
    public DataResult<AddressDto> findByAddressId(Integer addressId) {
        return new SuccessDataResult<>(addressDtoMapper.map(addressRepository.findByAddressId(addressId)));
    }
}


