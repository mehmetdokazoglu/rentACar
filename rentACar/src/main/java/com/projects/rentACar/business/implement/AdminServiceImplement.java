package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.AdminService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.Admin;
import com.projects.rentACar.mapper.AdminDtoMapper;
import com.projects.rentACar.mapper.AdminDtoRegisterMapper;
import com.projects.rentACar.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminDtoRegisterMapper adminRegisterDtoMapper;
    private final AdminDtoMapper adminDtoMapper;
    private final UserAuthenticationService userAuthenticationService;

    @Override
    public DataResult<AdminDto> register(AdminDto adminDto) {

        Admin admin = adminRepository.findByUser_UserName(adminDto.getUserDto().getUserName());

        if(admin != null){
            return new ErrorDataResult<>(null, "Bu kullanici adi sistemde kayitli");
        }
        return new SuccessDataResult<>(adminRegisterDtoMapper.map(adminRepository.save(adminRegisterDtoMapper.convertToEntity(adminDto))),"Admin kaydedildi");
    }

    @Override
    public DataResult<List<AdminDto>> getAllAdmins() {
        return new SuccessDataResult<>(adminDtoMapper.mapList(adminRepository.findAll()),"Adminler listelendi");
    }

    public String verify(UserDto userDto){
        return userAuthenticationService.verify(userDto);
    }

    @Override
    public Result delete(Integer adminId) {

        if(adminRepository.findByAdminId(adminId) == null){
            return new ErrorResult("Bu admin sistemde kayitli degil");
        }
        adminRepository.deleteById(adminId);
        return new SuccessResult("Admin basariyla silindi");
    }

}
