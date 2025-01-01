package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.entities.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerRelationDtoMapper {

    public SellerDto map(Seller seller){

        return new SellerDto.Builder()
                .sellerId(seller.getSellerId())
                .companyName(seller.getCompanyName())
                .phoneNumber(seller.getPhoneNumber())
                .userDto(new UserDtoMapperByOnlyUsername().map(seller.getUser()))
                .build();
    }

    public List<SellerDto> mapList(List<Seller> sellers){
        List<SellerDto> sellerDtoList = new ArrayList<>();
        for(Seller seller : sellers){
            sellerDtoList.add(this.map(seller));
        }
        return sellerDtoList;
    }

    public Seller convertToEntityByOnlyId(SellerDto sellerDto){
        Seller seller = new Seller();
        seller.setSellerId(sellerDto.getSellerId());
        return seller;
    }
}
