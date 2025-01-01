package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.CustomerSellerRelationService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.ErrorDataResult;
import com.projects.rentACar.core.result.SuccessDataResult;
import com.projects.rentACar.dtos.CustomerSellerRelationDto;
import com.projects.rentACar.dtos.CustomerSellerRelationFilterDto;
import com.projects.rentACar.entities.Customer;
import com.projects.rentACar.entities.CustomerSellerRelation;
import com.projects.rentACar.entities.Seller;
import com.projects.rentACar.mapper.CustomerSellerRelationDtoMapper;
import com.projects.rentACar.repository.CustomerRepository;
import com.projects.rentACar.repository.CustomerSellerRelationRepository;
import com.projects.rentACar.repository.SellerRepository;
import com.projects.rentACar.specification.CustomerSellerRelationSpecification;
import com.projects.rentACar.validation.DateOfBirthValidation;
import com.projects.rentACar.validation.PhoneNumberValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerSellerRelationServiceImplement implements CustomerSellerRelationService {

    private final CustomerSellerRelationRepository customerSellerRelationRepository;
    private final CustomerSellerRelationDtoMapper customerSellerRelationDtoMapper;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;


    @Override
    public DataResult<CustomerSellerRelationDto> add(@RequestBody CustomerSellerRelationDto customerSellerRelationDto) {

        if (customerSellerRelationDto == null || customerSellerRelationDto.getCustomerFilterDto() == null || customerSellerRelationDto.getSellerFilterDto() == null) {
            return new ErrorDataResult<>(null, "Lütfen alanları doldurunuz");
        }
        Customer customer = customerRepository.findByCustomerId(customerSellerRelationDto.getCustomerFilterDto().getCustomerId());
        if (customer == null) {
            return new ErrorDataResult<>(null, "Bu kullanıcı sistemde kayıtlı değil");
        }
        Seller seller = sellerRepository.findBySellerId(customerSellerRelationDto.getSellerFilterDto().getSellerId());
        if (seller == null) {
            return new ErrorDataResult<>(null, "Bu satıcı sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(customerSellerRelationDtoMapper.map(customerSellerRelationRepository.save
                (customerSellerRelationDtoMapper.convertToEntity(customerSellerRelationDto))), "Kayıt başarılı");
    }

    @Override
    public DataResult<List<CustomerSellerRelationDto>> getAllRelation() {
        return new SuccessDataResult<>(customerSellerRelationDtoMapper.mapList(customerSellerRelationRepository.findAll()), "Data listelendi");
    }

    @Override
    public DataResult<List<CustomerSellerRelationDto>> filter(CustomerSellerRelationFilterDto customerSellerRelationFilterDto) {
        List<CustomerSellerRelation> customerSellerRelations = customerSellerRelationRepository.findAll(
                CustomerSellerRelationSpecification.filterBySpecification(customerSellerRelationFilterDto));
        if (customerSellerRelations.isEmpty()) {
            return new ErrorDataResult<>(null, "Bu bilgilere ait bir kullanıcı sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>(customerSellerRelationDtoMapper.mapList(customerSellerRelations), "Data listelendi");
    }
}
