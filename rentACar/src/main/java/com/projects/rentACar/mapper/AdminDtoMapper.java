package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDtoMapper {

    public AdminDto map(Admin admin){

        return new AdminDto.Builder()
                .firstName(admin.getFirstName())
                .userDto(new UserDtoMapper().map(admin.getUser()))
                .lastName(admin.getLastName())
                .build();
    }

    public List<AdminDto> mapList(List<Admin> admins){
        List<AdminDto> adminDtoList = new ArrayList<>();
        for(Admin admin : admins){
            adminDtoList.add(this.map(admin));
        }
        return adminDtoList;
    }
}
