package com.projects.rentACar.specification;

import com.projects.rentACar.dtos.CarSellerRelationFilterDto;
import com.projects.rentACar.entities.Car;
import com.projects.rentACar.entities.CarSellerRelation;
import com.projects.rentACar.entities.Seller;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarSellerRelationSpecification implements Specification<CarSellerRelation> {

    @Override
    public Predicate toPredicate(Root<CarSellerRelation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<CarSellerRelation> filterBySpecification(CarSellerRelationFilterDto carSellerRelationFilterDto, LocalDate startDate, LocalDate endDate) {

        return ((root, query, criteriaBuilder) -> {

            Predicate predicate = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();

            if (carSellerRelationFilterDto != null) {

                Join<CarSellerRelation, Car> carJoin = root.join("car", JoinType.LEFT);
                Join<CarSellerRelation, Seller> sellerJoin = root.join("seller", JoinType.LEFT);

                if (carSellerRelationFilterDto.getCarFilterDto() != null) {
                    if (carSellerRelationFilterDto.getCarFilterDto().getCarName() != null) {
                        predicateList.add(criteriaBuilder.equal(carJoin.get("carName"), carSellerRelationFilterDto.getCarFilterDto().getCarName()));
                    }
                    if (carSellerRelationFilterDto.getCarFilterDto().getVehicleProductionDate() != null) {
                        if (startDate != null && endDate != null) {
                            predicateList.add(criteriaBuilder.between(carJoin.get("vehicleProductionDate"), startDate, endDate));
                        }
                    }
                }
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        });
    }
}
