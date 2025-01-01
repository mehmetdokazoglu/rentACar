package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.AddressDto;
import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressDtoMapper {

    @Autowired
    private SellerDtoRegisterMapper sellerDtoRegisterMapper;

    public AddressDto map(Address address){

        return new AddressDto.Builder()
                .addressId(address.getAddressId())
                .cityDto(new CityDtoMapper().map(address.getCity()))
                .districtDto(new DistrictDtoMapper().map(address.getDistrict()))
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .apartment(address.getApartment())
                .apartmentNumber(address.getApartmentNumber())
                .sellerDto(sellerDtoRegisterMapper.map(address.getSeller()))
                .build();
    }

    public AddressDto mapBySeller(Address address){

        return new AddressDto.Builder()
                .addressId(address.getAddressId())
                .cityDto(new CityDtoMapper().map(address.getCity()))
                .districtDto(new DistrictDtoMapper().map(address.getDistrict()))
                .build();
    }

    public List<AddressDto> mapBySellerList(List<Address> addresses){
        List<AddressDto> addressDtoList = new ArrayList<>();
        for(Address address : addresses){
            addressDtoList.add(this.mapBySeller(address));
        }
        return addressDtoList;
    }

    public List<AddressDto> mapList(List<Address> addresses){
        List<AddressDto> addressDtoList = new ArrayList<>();
        for(Address address : addresses){
            addressDtoList.add(this.map(address));
        }
        return addressDtoList;
    }

    public Address convertToEntity(AddressDto addressDto) {
        Address address= new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setCity(new CityDtoMapper().convertToEntity(addressDto.getCityDto()));
        address.setDistrict(new DistrictDtoMapper().convertToEntity(addressDto.getDistrictDto()));
        address.setNeighborhood(addressDto.getNeighborhood());
        address.setStreet(addressDto.getStreet());
        address.setApartment(addressDto.getApartment());
        address.setApartmentNumber(addressDto.getApartmentNumber());
        address.setSeller(sellerDtoRegisterMapper.convertToEntity(addressDto.getSellerDto()));
        return address;
    }

    public List<Address> convertToEntityList(List<AddressDto> addressDtoList){
        List<Address> addressList = new ArrayList<>();
        for(AddressDto addressDto : addressDtoList){
            addressList.add(this.convertToEntity(addressDto));
        }
        return addressList;
    }
}
