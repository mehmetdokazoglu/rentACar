package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.SellerService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.Seller;
import com.projects.rentACar.mapper.SellerDtoMapper;
import com.projects.rentACar.mapper.SellerDtoRegisterMapper;
import com.projects.rentACar.repository.SellerRepository;
import com.projects.rentACar.validation.EmailValidation;
import com.projects.rentACar.validation.PhoneNumberValidation;
import com.projects.rentACar.validation.UserNameValidation;
import jakarta.validation.ConstraintDeclarationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImplement implements SellerService {

    private final SellerRepository sellerRepository;
    private final SellerDtoRegisterMapper sellerDtoRegisterMapper;
    private final SellerDtoMapper sellerDtoMapper;

    private final EmailValidation emailValidation;
    private final PhoneNumberValidation phoneNumberValidation;
    private final UserNameValidation userNameValidation;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    public DataResult<SellerDto> register(SellerDto sellerDto) {

        Result result = new SuccessResult();

        if (sellerDto == null || sellerDto.getUserDto() == null) {
            return new ErrorDataResult<>(null, "Lütfen istenen bilgileri doldurunuz");
        }
        if (sellerDto.getCompanyName() == null || sellerDto.getCompanyName().isEmpty()) {
            return new ErrorDataResult<>(null, "Şirket adınızı giriniz");
        }
        result = this.phoneNumberValidation.validate(sellerDto);
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        result = this.emailValidation.validate(sellerDto.getUserDto());
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        result = this.userNameValidation.validate(sellerDto.getUserDto());
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        return new SuccessDataResult<>(sellerDtoRegisterMapper.map(sellerRepository.save(sellerDtoRegisterMapper.convertToEntity(sellerDto))), "Firma eklendi");
    }

    @Override
    public String verify(UserDto userDto) {
        return userAuthenticationService.verify(userDto);
    }

    @Override
    public DataResult<List<SellerDto>> getAllSeller() {
        return new SuccessDataResult<>(sellerDtoMapper.mapList(sellerRepository.findAll()), "Firmalar listelendi");
    }


    @Override
    public DataResult<SellerDto> update(SellerDto sellerDto) {
        Seller resultSeller = sellerRepository.findBySellerId(sellerDto.getSellerId());
        if (resultSeller == null) {
            throw new NullPointerException("Firma bulunamadı");
        }
        return new SuccessDataResult<>(sellerDtoRegisterMapper.map(sellerRepository.save(sellerDtoRegisterMapper.convertToEntity(sellerDto))), "Firma güncellendi");
    }

    @Override
    public Result delete(Integer sellerId) {
        if (sellerId == null) {
            new ErrorResult("Lütfen bir id giriniz");
        }
        Seller seller = sellerRepository.findBySellerId(sellerId);
        if (seller == null) {
            return new ErrorResult("Bu firma sistemde kayıtlı değil");
        }
        sellerRepository.findBySellerId(sellerId);
        return new SuccessResult("Firma başarıyla silindi");
    }

    @Override
    public DataResult<SellerDto> findByCompanyName(String companyName) {
        if (sellerRepository.findByCompanyName(companyName) == null) {
            return new ErrorDataResult<>(null, "Bu şirket adı sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(sellerDtoMapper.map(sellerRepository.findByCompanyName(companyName)), "Data listelendi");
    }
}