package com.projects.rentACar.specification;

import com.projects.rentACar.dtos.UserFilterDto;
import com.projects.rentACar.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {// Dinamik sql sorguları oluşturmamızı sağlar.
        return null;
    }

    public static Specification<User> filterBySpecification(UserFilterDto userFilterDto) {//UserFilterDto'ya göre dinamik sorgular oluşturmak için

        return ((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();

            if(userFilterDto != null){
                if(userFilterDto.getUserName() != null){
                    predicateList.add(criteriaBuilder.equal(root.get("userName"), userFilterDto.getUserName()));
                }
                if(userFilterDto.getEmail() != null){
                    predicateList.add(criteriaBuilder.equal(root.get("email"), userFilterDto.getEmail()));
                }
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        });
    }

}
