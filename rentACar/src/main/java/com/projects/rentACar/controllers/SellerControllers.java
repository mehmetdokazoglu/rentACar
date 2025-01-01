package com.projects.rentACar.controllers;

import com.projects.rentACar.business.SellerService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.dtos.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellerControllers {

    private final SellerService sellerService;

    @PostMapping("/register")
    public DataResult<SellerDto> register(@Valid @RequestBody SellerDto sellerDto){
        return sellerService.register(sellerDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return sellerService.verify(userDto);
    }

    @PreAuthorize("hasAuthority('MANAGE_SELLER')")
    @GetMapping("/getAllSeller")
    public DataResult<List<SellerDto>> getAllSeller(){
        return sellerService.getAllSeller();
    }


    @PreAuthorize("hasAuthority('MANAGE_SELLER')")
    @PutMapping("/update")
    public DataResult<SellerDto> update(@RequestBody SellerDto sellerDto){
        return sellerService.update(sellerDto);
    }

    @PreAuthorize("hasAuthority('MANAGE_SELLER')")
    @DeleteMapping("/delete/{userId}")
    public Result delete(Integer userId){
        return sellerService.delete(userId);
    }

    @GetMapping("/findByCompanyName")
    public DataResult<SellerDto> findByCompanyName(@RequestParam String companyName){
        return sellerService.findByCompanyName(companyName);
    }
}
