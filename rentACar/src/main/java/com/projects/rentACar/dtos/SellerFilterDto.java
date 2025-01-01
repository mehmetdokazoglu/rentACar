package com.projects.rentACar.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerFilterDto {

    private Integer sellerId;
    private String companyName;
    private String phoneNumber;
}
