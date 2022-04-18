package com.myapp.vehicle.contract.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.myapp.vehicle.contract.service.api.model.Customer;

public class CustomerMapper {

	public static List<Customer> mapToRestCustomers(
			List<com.myapp.vehicle.contract.service.repository.Customer> customerEntities) {
		List<Customer> customers = new ArrayList<>();
		customerEntities.forEach(customerEntity -> {
			Customer restCustomer = mapToRestCustomer(customerEntity);
			customers.add(restCustomer);
		});
		return customers;
	}
	
	public static Customer mapToRestCustomer(com.myapp.vehicle.contract.service.repository.Customer customerEntity) {
		Customer restCustomer = new Customer().id(customerEntity.getId()).firstName(customerEntity.getFirstName())
				.lastName(customerEntity.getLastName()).birthDate(customerEntity.getBirthDate());
		return restCustomer;
	}
	
	public static com.myapp.vehicle.contract.service.repository.Customer mapToCustomerEntity(Customer customer) {
		com.myapp.vehicle.contract.service.repository.Customer customerEntity = new com.myapp.vehicle.contract.service.repository.Customer();
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setBirthDate(customer.getBirthDate());
		return customerEntity;
	}
}
