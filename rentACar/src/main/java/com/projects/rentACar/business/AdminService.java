package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.dtos.UserDto;

import java.util.List;

public interface AdminService {

    DataResult<AdminDto> register(AdminDto adminDto);
    DataResult<List<AdminDto>> getAllAdmins();
    String verify(UserDto userDto);
    Result delete(Integer adminId);
}
