package com.myapp.vehicle.contract.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.vehicle.contract.service.api.CustomersApi;
import com.myapp.vehicle.contract.service.api.model.Customer;
import com.myapp.vehicle.contract.service.exception.ResourceNotFoundException;
import com.myapp.vehicle.contract.service.mapper.CustomerMapper;
import com.myapp.vehicle.contract.service.repository.CustomerRepository;

@RestController
public class CustomerController implements CustomersApi {

   @Autowired
   private CustomerRepository customerRepository;
	
   @Override
   public ResponseEntity<List<Customer>> getCustomers() {
	   return ResponseEntity.ok(CustomerMapper.mapToRestCustomers(customerRepository.findAll()));
   }
   
   @Override
   public ResponseEntity<Customer> getCustomerById(Long id) {
	   com.myapp.vehicle.contract.service.repository.Customer customerEntity = 
			   customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id)); 
	   return ResponseEntity.ok(CustomerMapper.mapToRestCustomer(customerEntity));
   }
   
   @Override
   public ResponseEntity<Customer> updateCustomerDeatilsById(Long id, Customer customer) {
	   com.myapp.vehicle.contract.service.repository.Customer customerEntity = 
			   customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
	   customerEntity.setFirstName(customer.getFirstName());
	   customerEntity.setLastName(customer.getLastName());
	   customerEntity.setBirthDate(customer.getBirthDate());
	   customerRepository.save(customerEntity);
       return ResponseEntity.ok(CustomerMapper.mapToRestCustomer(customerEntity));
   }
   
   @Override
   public ResponseEntity<Customer> addCustomer(Customer customer) {
	   com.myapp.vehicle.contract.service.repository.Customer customerEntity =  CustomerMapper.mapToCustomerEntity(customer);
	   customerRepository.save(customerEntity);
	   return ResponseEntity.ok(CustomerMapper.mapToRestCustomer(customerEntity));
   }
   
}
