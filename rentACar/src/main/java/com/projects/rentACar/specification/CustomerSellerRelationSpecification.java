package com.projects.rentACar.specification;

import com.projects.rentACar.dtos.CustomerSellerRelationFilterDto;
import com.projects.rentACar.entities.Customer;
import com.projects.rentACar.entities.CustomerSellerRelation;
import com.projects.rentACar.entities.Seller;
import com.projects.rentACar.entities.User;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSellerRelationSpecification implements Specification<CustomerSellerRelation> {

    @Override
    public Predicate toPredicate(Root<CustomerSellerRelation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<CustomerSellerRelation> filterBySpecification(CustomerSellerRelationFilterDto customerSellerRelationFilterDto) {

        return ((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();

            if (customerSellerRelationFilterDto != null) {

                Join<CustomerSellerRelation, Customer> customerJoin = root.join("customer", JoinType.LEFT);
                Join<Customer, User> customerUserJoin = customerJoin.join("user", JoinType.LEFT);

                Join<CustomerSellerRelation, Seller> sellerJoin = root.join("seller", JoinType.LEFT);
                Join<Seller, User> sellerUserJoin = sellerJoin.join("user", JoinType.LEFT);

                if (customerSellerRelationFilterDto.getCustomerFilterDto() != null) {
                    if (customerSellerRelationFilterDto.getCustomerFilterDto().getFirstName() != null) {
                        predicateList.add(criteriaBuilder.or(
                                criteriaBuilder.like(customerJoin.get("firstName"), customerSellerRelationFilterDto.getCustomerFilterDto().getFirstName() + "%"),
                                criteriaBuilder.equal(customerJoin.get("firstName"), customerSellerRelationFilterDto.getCustomerFilterDto().getFirstName())));
                    }
                    if (customerSellerRelationFilterDto.getCustomerFilterDto().getLastName() != null) {
                        predicateList.add(criteriaBuilder.equal(customerJoin.get("lastName"), customerSellerRelationFilterDto.getCustomerFilterDto().getLastName()));
                    }
                }

                if (customerSellerRelationFilterDto.getSellerFilterDto() != null) {
                    if (customerSellerRelationFilterDto.getSellerFilterDto().getCompanyName() != null) {
                        predicateList.add(criteriaBuilder.equal(sellerJoin.get("companyName"), customerSellerRelationFilterDto.getSellerFilterDto().getCompanyName()));
                    }
                }

                if (customerSellerRelationFilterDto.getUserFilterDto() != null) {
                    if (customerSellerRelationFilterDto.getUserFilterDto().getUserName() != null) {
                        predicateList.add(criteriaBuilder.or(
                                criteriaBuilder.equal(customerUserJoin.get("userName"), customerSellerRelationFilterDto.getUserFilterDto().getUserName()),
                                criteriaBuilder.equal(sellerUserJoin.get("userName"), customerSellerRelationFilterDto.getUserFilterDto().getUserName())));
                    }
                    if (customerSellerRelationFilterDto.getUserFilterDto().getEmail() != null) {
                        predicateList.add(criteriaBuilder.or(
                                criteriaBuilder.equal(customerUserJoin.get("email"), customerSellerRelationFilterDto.getUserFilterDto().getEmail()),
                                criteriaBuilder.equal(sellerUserJoin.get("email"), customerSellerRelationFilterDto.getUserFilterDto().getEmail())));
                    }
                }
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        });
    }
}


//  return ((root, query, criteriaBuilder) -> {
//Predicate predicate = criteriaBuilder.disjunction();
//List<Predicate> predicateList = new ArrayList<>();
//
//            if (customerSellerRelationFilterDto != null) {
//Join<CustomerSellerRelation, Customer> customerJoin = root.join("customer", JoinType.LEFT);
//Join<Customer, User> customerUserJoin = customerJoin.join("user", JoinType.LEFT);
//
//Join<CustomerSellerRelation, Seller> sellerJoin = root.join("seller", JoinType.LEFT);
//Join<Seller, User> sellerUserJoin = sellerJoin.join("user", JoinType.LEFT);
//
//                if (customerSellerRelationFilterDto.getCustomerFilterDto() != null &&
//        customerSellerRelationFilterDto.getCustomerFilterDto().getUserFilterDto() != null &&
//        customerSellerRelationFilterDto.getCustomerFilterDto().getUserFilterDto().getUserName() != null) {
//        predicateList.add(criteriaBuilder.like(customerUserJoin.get("userName"),
//                            "%" + customerSellerRelationFilterDto.getCustomerFilterDto().getUserFilterDto().getUserName() + "%"));
//        }
//        if (customerSellerRelationFilterDto.getSellerFilterDto() != null &&
//        customerSellerRelationFilterDto.getSellerFilterDto().getUserFilterDto() != null &&
//        customerSellerRelationFilterDto.getSellerFilterDto().getUserFilterDto().getUserName() != null) {
//        predicateList.add(criteriaBuilder.like(sellerUserJoin.get("userName"),
//                            "%" + customerSellerRelationFilterDto.getSellerFilterDto().getUserFilterDto().getUserName() + "%"));
//        }
//        }
//        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
//        });