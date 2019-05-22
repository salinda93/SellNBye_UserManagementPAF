package com.PAF_UserManagementSellNBye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PAF_UserManagementSellNBye.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
