package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.UserService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.ErrorDataResult;
import com.projects.rentACar.core.result.SuccessDataResult;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.dtos.UserFilterDto;
import com.projects.rentACar.entities.User;
import com.projects.rentACar.mapper.UserDtoMapper;
import com.projects.rentACar.mapper.UserDtoRegisterMapper;
import com.projects.rentACar.repository.UserRepository;
import com.projects.rentACar.specification.CustomerSpecification;
import com.projects.rentACar.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final UserDtoRegisterMapper userDtoRegisterMapper;
    private final UserDtoMapper userDtoMapper;

    @Override
    public DataResult<UserDto> register(UserDto userDto) {
        return new SuccessDataResult<>(userDtoRegisterMapper.map(userRepository.save(userDtoRegisterMapper.convertToEntity(userDto))), "Kullanıcı eklendi");
    }

    @Override
    public DataResult<List<UserDto>> getAll() {
        return new SuccessDataResult<>(userDtoMapper.mapList(userRepository.findAll()),"Kullanıcılar listelendi");
    }

    @Override
    public DataResult<UserDto> update(UserDto userDto) {
        User resultUser = userRepository.findByUserId(userDto.getUserId());
        if(resultUser == null){
            throw new NullPointerException("Kullanıcı bulunamadı");
        }
        return new SuccessDataResult<>(userDtoRegisterMapper.map(userRepository.save(userDtoRegisterMapper.convertToEntity(userDto))), "Kullanıcı güncellendi");
    }

    @Override
    public DataResult<List<UserDto>> filter(UserFilterDto userFilterDto) {
        List<User> users = userRepository.findAll(UserSpecification.filterBySpecification(userFilterDto));
        if(users.isEmpty()){
            return new ErrorDataResult<>(null, "Bu bilgilere sahip bir kullanıcı sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(userDtoMapper.mapList(users), "Data listelendi");
    }


}
