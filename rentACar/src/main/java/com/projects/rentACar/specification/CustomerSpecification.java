package com.projects.rentACar.specification;

import com.projects.rentACar.dtos.CustomerDtoFilterSpec;
import com.projects.rentACar.entities.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification implements Specification<Customer> {


    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<Customer> filterBySpecification(CustomerDtoFilterSpec customerDtoFilterSpec) {

        return ((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();

            if(customerDtoFilterSpec != null){
                if(customerDtoFilterSpec.getFirstName() != null ){
                    predicateList.add(criteriaBuilder.equal(root.get("firstName"), customerDtoFilterSpec.getFirstName()));
                }if(customerDtoFilterSpec.getLastName() != null){
                    predicateList.add(criteriaBuilder.equal(root.get("lastName"), customerDtoFilterSpec.getLastName()));
                }
                if(customerDtoFilterSpec.getUserFilterDto() != null){
                    if(customerDtoFilterSpec.getUserFilterDto().getUserName() != null){
                        predicateList.add(criteriaBuilder.equal(root.get("user").get("userName"), customerDtoFilterSpec.getUserFilterDto().getUserName()));
                    }
                    if(customerDtoFilterSpec.getUserFilterDto().getEmail() != null){
                        predicateList.add(criteriaBuilder.equal(root.get("user").get("email"), customerDtoFilterSpec.getUserFilterDto().getEmail()));
                    }
                }
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        });
    }
}
