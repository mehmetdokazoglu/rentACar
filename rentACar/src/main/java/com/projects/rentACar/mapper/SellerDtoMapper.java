package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.entities.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerDtoMapper {

    public SellerDto map(Seller seller){

        return new SellerDto.Builder()
                .companyName(seller.getCompanyName())
                .userDto(new UserDtoMapper().map(seller.getUser()))
                .phoneNumber(seller.getPhoneNumber())
                .build();
    }

    public SellerDto mapByOnlyCompanyName(Seller seller){

        return new SellerDto.Builder()
                .companyName(seller.getCompanyName())
                .build();
    }

    public List<SellerDto> mapList(List<Seller> sellers){
        List<SellerDto> sellerDtoList = new ArrayList<>();
        for(Seller seller : sellers){
            sellerDtoList.add(this.map(seller));
        }
        return sellerDtoList;
    }
}
