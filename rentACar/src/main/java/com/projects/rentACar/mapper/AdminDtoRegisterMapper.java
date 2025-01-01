package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.entities.Admin;
import com.projects.rentACar.entities.User;
import com.projects.rentACar.entities.enums.Permission;
import com.projects.rentACar.entities.enums.Role;
import com.projects.rentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminDtoRegisterMapper {

        private final UserRepository userRepository;

        public AdminDto map(Admin admin) {

            return new AdminDto.Builder()
                    .adminId(admin.getAdminId())
                    .userDto(new UserDtoRegisterMapper().map(admin.getUser()))
                    .firstName(admin.getFirstName())
                    .lastName(admin.getLastName())
                    .build();
        }

        public List<AdminDto> mapList(List<Admin> admins) {
            List<AdminDto> adminDtoList = new ArrayList<>();
            for (Admin admin : admins) {
                adminDtoList.add(this.map(admin));
            }
            return adminDtoList;
        }

        public Admin convertToEntity(AdminDto adminDto) {

            User user = new UserDtoRegisterMapper().convertToEntity(adminDto.getUserDto());
            user.setRole(Role.ADMIN);
            user.setPermissions(Permission.getPermissionByRole(Role.ADMIN));
            user = userRepository.save(user);


            Admin admin = new Admin();
            admin.setAdminId(adminDto.getAdminId());
            admin.setFirstName(adminDto.getFirstName());
            admin.setLastName(adminDto.getLastName());
            admin.setUser(user);
            return admin;
        }
    }

