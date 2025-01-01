package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.SellerFilterDto;
import com.projects.rentACar.entities.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerDtoFilterMapper {

    public SellerFilterDto map(Seller seller){

        return SellerFilterDto.builder()
                .companyName(seller.getCompanyName())
                .phoneNumber(seller.getPhoneNumber())
                .build();
    }


    public List<SellerFilterDto> mapList(List<Seller> sellers){
        List<SellerFilterDto> sellerDtoList = new ArrayList<>();
        for(Seller seller : sellers){
            sellerDtoList.add(this.map(seller));
        }
        return sellerDtoList;
    }

    public Seller convertToEntityByOnlyId(SellerFilterDto sellerFilterDto){
        Seller seller = new Seller();
        seller.setSellerId(sellerFilterDto.getSellerId());
        return seller;
    }
}
