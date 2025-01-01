package com.projects.rentACar.entities.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum Permission {

    MANAGE_CAR(1, "Manager Car", List.of(Role.ADMIN, Role.SELLER)),
    MANAGE_CITY(2, "Manager City", List.of(Role.ADMIN)),
    MANAGE_ADDRESS(3, "Manager Address", List.of(Role.ADMIN)),
    MANAGE_DISTRICT(4, "Manager District", List.of(Role.ADMIN)),
    MANAGE_USER(5, "Manager User", List.of(Role.ADMIN)),
    MANAGE_CUSTOMER(6, "Manager Customer", List.of(Role.ADMIN)),
    MANAGE_ADMIN(7, "Manager Admin", List.of(Role.ADMIN)),
    MANAGE_FEATURE(8, "Manager Feature", List.of(Role.ADMIN)),
    MANAGE_SELLER(9, "Manager Seller", List.of(Role.ADMIN)),
    ADD_CAR(10, "Manager Car", List.of(Role.ADMIN)),
    GET_ALL_CAR(11, "Manager GetAllCar", List.of(Role.ADMIN, Role.CUSTOMER)),
    MANAGE_OWN_PROFILE(12, "Manager OwnProfile", List.of( Role.SELLER)),
    MANAGE_OWN_CARS(13, "Manager OwnCars", List.of( Role.SELLER)),
    MANAGE_OWN_PROFILE_CUSTOMER(14, "Manager OwnProfileCustomer", List.of(Role.CUSTOMER));

    private final Integer id;
    private String detail;
    private List<Role> roleList;


    Permission(Integer id, String detail, List<Role> roleList) {
        this.id = id;
        this.detail = detail;
        this.roleList = roleList;
    }

    public static List<Permission> getPermissionByRole(Role role) {

        return List.of(values()).stream()
                .filter(permission -> permission.getRoleList().contains(role))
                .toList();
    }
}
