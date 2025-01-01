package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoRegisterMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);

    public UserDto map(User user){

        return new UserDto.Builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public List<UserDto> mapList(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            userDtoList.add(this.map(user));
        }
        return userDtoList;
    }

    public User convertToEntity(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName().trim().toLowerCase());
        user.setEmail(userDto.getEmail().trim().toLowerCase());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
