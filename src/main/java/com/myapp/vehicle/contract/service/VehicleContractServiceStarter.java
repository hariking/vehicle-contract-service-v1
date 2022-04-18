package com.myapp.vehicle.contract.service;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapp.vehicle.contract.service.repository.Amount;
import com.myapp.vehicle.contract.service.repository.AmountRepository;
import com.myapp.vehicle.contract.service.repository.Customer;
import com.myapp.vehicle.contract.service.repository.CustomerRepository;
import com.myapp.vehicle.contract.service.repository.LeaseContract;
import com.myapp.vehicle.contract.service.repository.LeaseContractRepository;
import com.myapp.vehicle.contract.service.repository.Vehicle;
import com.myapp.vehicle.contract.service.repository.VehicleRepository;

@SpringBootApplication
public class VehicleContractServiceStarter {

	private static Logger logger = LogManager.getLogger(VehicleContractServiceStarter.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private LeaseContractRepository leaseContractRepository;
	
	@Autowired
	private AmountRepository amountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleContractServiceStarter.class, args);
	}

	@PostConstruct
	public void addSampleDataIntoDB() {
		Customer customer1 = new Customer("John", "Abraham", "12-10-1995");
		customerRepository.save(customer1);
		Customer customer2 = new Customer("Bhem", "Kolter", "10-04-1985");
		customerRepository.save(customer2);
		Customer customer3 = new Customer("Edwert", "Roberrt", "10-04-1985");
		customerRepository.save(customer3);
		
		logger.info("Added Sample Customers: {} ", customerRepository.count());

		Vehicle vehicle1 = new Vehicle("BMW","X3","2010", null, amountRepository.save(new Amount("1000000", 2, "EUR")) );
		vehicleRepository.save(vehicle1);
		Vehicle vehicle2 = new Vehicle("AUDI","Q7","2020", null,  amountRepository.save(new Amount("1050000", 2, "EUR")) );
		vehicleRepository.save(vehicle2);
		Vehicle vehicle3 = new Vehicle("KIA","SELTOS","2015", null,  amountRepository.save(new Amount("1400000", 2, "EUR"))  );
		vehicleRepository.save(vehicle3);
		
		logger.info("Added Sample Vehicles: {} ", vehicleRepository.count());
		
		LeaseContract leaseContract1 = new LeaseContract("1231234",  amountRepository.save(new Amount("140000", 2, "EUR")), customer1, vehicle1);
		leaseContractRepository.save(leaseContract1);
		LeaseContract leaseContract2 = new LeaseContract("1232345",  amountRepository.save(new Amount("280000", 2, "EUR")) ,customer2, vehicle2);
		leaseContractRepository.save(leaseContract2);
		LeaseContract leaseContract3 = new LeaseContract("1233456",  amountRepository.save(new Amount("360000", 2, "EUR")) ,customer3, vehicle3);
		leaseContractRepository.save(leaseContract3);
		
		logger.info("Added Sample Contracts: {} ", leaseContractRepository.count());
	}
	

}
