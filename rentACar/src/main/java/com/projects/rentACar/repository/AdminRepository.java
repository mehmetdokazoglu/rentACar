package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUser_UserName(String userName);
    Admin findByAdminId(Integer adminId);
}
