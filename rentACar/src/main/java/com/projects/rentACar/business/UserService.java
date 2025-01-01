package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.dtos.UserFilterDto;
import com.projects.rentACar.entities.User;

import java.util.List;

public interface UserService {

    DataResult<UserDto> register(UserDto userDto);
    DataResult<List<UserDto>> getAll();
    DataResult<UserDto> update(UserDto userDto);
    DataResult<List<UserDto>> filter(UserFilterDto userFilterDto);
}
