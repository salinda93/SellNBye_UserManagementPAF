package com.PAF_UserManagementSellNBye.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PAF_UserManagementSellNBye.dao.CustomerDAO;
import com.PAF_UserManagementSellNBye.model.Customer;

@RestController
@RequestMapping("/SellNBye")
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	//to save a customer 
	
	@PostMapping("/customers") 
	public Customer createCustomer(@Valid @RequestBody Customer cus1) {
		return customerDAO.save(cus1);
	}
	
	// get all customer
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerDAO.findAll();
	}
	
	//get customer by cus1id
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long cus1id){
		
		 Customer cus1 = customerDAO.findOne(cus1id);
		 
		 if(cus1 == null) {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok().body(cus1);
	}
	
	//update customer by cus1id
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long cus1id,@Valid @RequestBody Customer cus1Details){
		
		Customer cus1 = customerDAO.findOne(cus1id);
		
		 if(cus1 == null) {
			 return ResponseEntity.notFound().build();
			 
		 }
		 
		 cus1.setName(cus1Details.getName());
		 cus1.setAddress(cus1Details.getAddress());
		 cus1.setEmail(cus1Details.getEmail());
		 cus1.setPhoneNo(cus1Details.getPhoneNo());
		 
		 Customer updateCustomer = customerDAO.save(cus1);
		 
		 return ResponseEntity.ok().body(updateCustomer);
	}
	
	//delete a customer
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer>deletEmployee(@PathVariable(value = "id") Long cus1id){
		
		Customer cus1 = customerDAO.findOne(cus1id);
		
		if(cus1 == null) {
			 return ResponseEntity.notFound().build();
			 
		 }
		
		customerDAO.delete(cus1);
		
		return ResponseEntity.ok().build();
		 
		
	}

}
