package com.projects.rentACar.controllers;

import com.projects.rentACar.business.AddressService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.AddressDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('MANAGE_ADDRESS')")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public DataResult<AddressDto> add(@Valid @RequestBody AddressDto addressDto){
        return addressService.add(addressDto);
    }

    @GetMapping("/getAllAddress")
    public DataResult<List<AddressDto>> getAllAddress(){
        return addressService.getAllAddress();
    }

    @PutMapping("/update")
    public DataResult<AddressDto> update(@RequestBody AddressDto addressDto){
        return addressService.update(addressDto);
    }

    @DeleteMapping("/delete/{addressId}")
    public Result delete(@PathVariable Integer addressId){
        return addressService.delete(addressId);
    }

    @GetMapping("/findByAddressId")
    public DataResult<AddressDto> findByAddressId(@RequestParam Integer addressId){
        return addressService.findByAddressId(addressId);
    }
}
