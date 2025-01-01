package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.entities.Seller;
import com.projects.rentACar.entities.User;
import com.projects.rentACar.entities.enums.Permission;
import com.projects.rentACar.entities.enums.Role;
import com.projects.rentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SellerDtoRegisterMapper {

    private final UserRepository userRepository;

    public SellerDto map(Seller seller){

        return new SellerDto.Builder()
                .sellerId(seller.getSellerId())
                .companyName(seller.getCompanyName())
                .userDto(new UserDtoRegisterMapper().map(seller.getUser()))
                .phoneNumber(seller.getPhoneNumber())
                .build();
    }

    public List<SellerDto> mapList(List<Seller> sellers){
        List<SellerDto> sellerDtoList = new ArrayList<>();
        for(Seller seller : sellers){
            sellerDtoList.add(this.map(seller));
        }
        return sellerDtoList;
    }

    public Seller convertToEntity(SellerDto sellerDto){

        User user = new UserDtoRegisterMapper().convertToEntity(sellerDto.getUserDto());
        user.setRole(Role.SELLER);
        user.setPermissions(Permission.getPermissionByRole(Role.SELLER));
        user = userRepository.save(user);

        Seller seller = new Seller();
        seller.setSellerId(sellerDto.getSellerId());
        seller.setCompanyName(sellerDto.getCompanyName().trim().toUpperCase());
        seller.setUser(user);
        seller.setPhoneNumber(sellerDto.getPhoneNumber());

        return seller;
    }

    public Seller convertToEntityByOnlyId(SellerDto sellerDto){
        Seller seller = new Seller();
        seller.setSellerId(sellerDto.getSellerId());
        return seller;
    }
}
