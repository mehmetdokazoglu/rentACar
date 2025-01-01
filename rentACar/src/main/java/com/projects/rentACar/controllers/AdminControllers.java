package com.projects.rentACar.controllers;

import com.projects.rentACar.business.AdminService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.dtos.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminControllers {

    private final AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<DataResult<AdminDto>> register(@RequestBody @Valid AdminDto adminDto) {
        DataResult<AdminDto> result = adminService.register(adminDto);
        return new ResponseEntity<>(result , result.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/register")
//    public DataResult<AdminDto> register(@Valid @RequestBody AdminDto adminDto){
//        return adminService.register(adminDto);
//    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return adminService.verify(userDto);
    }

    @GetMapping("/getAllAdmin")
    public DataResult<List<AdminDto>> getAllAdmins(){
       return adminService.getAllAdmins();
    }


    @DeleteMapping("/delete/{userId}")
    public Result delete(Integer userId){
        return adminService.delete(userId);
    }
}
