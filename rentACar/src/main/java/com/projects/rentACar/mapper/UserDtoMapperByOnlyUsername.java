package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoMapperByOnlyUsername {

    public UserDto map(User user){

        if (user == null) {
            return null;
        }

        return new UserDto.Builder()
                .userName(user.getUserName())
                .build();
    }

    public List<UserDto> mapList(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            userDtoList.add(this.map(user));
        }
        return userDtoList;
    }
}
