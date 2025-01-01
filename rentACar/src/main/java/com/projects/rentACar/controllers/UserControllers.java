package com.projects.rentACar.controllers;

import com.projects.rentACar.business.UserService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.dtos.UserFilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_USER')")
public class UserControllers {

    private final UserService userService;

    @PostMapping("/register")
    public DataResult<UserDto> register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<UserDto>> getAll(){
        return userService.getAll();
    }

    @PutMapping("/update")
    public DataResult<UserDto> update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }

    @PostMapping("/filter")
    public DataResult<List<UserDto>> filter(@RequestBody UserFilterDto userFilterDto){
        return userService.filter(userFilterDto);
    }
}
