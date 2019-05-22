package com.PAF_UserManagementSellNBye.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PAF_UserManagementSellNBye.model.Customer;
import com.PAF_UserManagementSellNBye.repository.CustomerRepository;

@Service
public class CustomerDAO {
	
	@Autowired
	CustomerRepository customerRepository;
	
	//to save a customer
	
	public Customer save(Customer cus1) {
		return customerRepository.save(cus1);
	}
	
	
	//search all customer
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	
	//get a customer by id
	
	public Customer findOne(Long cus1id) {
		return customerRepository.findOne(cus1id);
	}
	
	
	//delate a customer
	
	public void delete(Customer cus1) {
		customerRepository.delete(cus1);
	}

}
