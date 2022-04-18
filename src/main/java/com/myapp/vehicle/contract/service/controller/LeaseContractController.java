package com.myapp.vehicle.contract.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.vehicle.contract.service.api.LeaseContractsApi;
import com.myapp.vehicle.contract.service.api.model.LeaseContract;
import com.myapp.vehicle.contract.service.exception.ResourceNotFoundException;
import com.myapp.vehicle.contract.service.mapper.AmountMapper;
import com.myapp.vehicle.contract.service.mapper.LeaseContractMapper;
import com.myapp.vehicle.contract.service.repository.Amount;
import com.myapp.vehicle.contract.service.repository.AmountRepository;
import com.myapp.vehicle.contract.service.repository.CustomerRepository;
import com.myapp.vehicle.contract.service.repository.LeaseContractRepository;
import com.myapp.vehicle.contract.service.repository.VehicleRepository;

@RestController
public class LeaseContractController implements LeaseContractsApi{

	@Autowired
	private LeaseContractRepository leaseContractRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	   @Autowired
	   private CustomerRepository customerRepository;
	
	@Autowired
	private AmountRepository amountRepository;
	
    @Override
    public ResponseEntity<List<LeaseContract>> getLeaseContracts() {
    	return ResponseEntity.ok(LeaseContractMapper.mapToRestLeaseContracts(leaseContractRepository.findAll()));
    }
    
    @Override
	public ResponseEntity<LeaseContract> getLeaseContractById(Long id) {
		com.myapp.vehicle.contract.service.repository.LeaseContract leaseContractEntity = leaseContractRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lease Contract not exist with id :" + id));
		return ResponseEntity.ok(LeaseContractMapper.mapToRestLeaseContract(leaseContractEntity));
	}
    
    @Override
    public ResponseEntity<LeaseContract> addLeaseContract(LeaseContract leaseContract) {
    	Amount monthlyRentEntity = amountRepository.save(AmountMapper.mapToAmountEntity(leaseContract.getMonthlyRent()));
    	com.myapp.vehicle.contract.service.repository.LeaseContract leaseContractEntity = LeaseContractMapper.mapToLeaseContractEntity(leaseContract, monthlyRentEntity);
    	leaseContractEntity.setCustomer(customerRepository.findById(leaseContract.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + leaseContract.getCustomer().getId())));
		leaseContractEntity.setVehicle(vehicleRepository.findById(leaseContract.getVehicle().getId())
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + leaseContract.getVehicle().getId())));
    	leaseContractRepository.save(leaseContractEntity);
        return ResponseEntity.ok(LeaseContractMapper.mapToRestLeaseContract(leaseContractEntity));
    }
    
    @Override
    public ResponseEntity<LeaseContract> updateLeaseContractById(Long id, LeaseContract leaseContract) {
    	com.myapp.vehicle.contract.service.repository.LeaseContract leaseContractEntity = leaseContractRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lease Contract not exist with id :" + id));
    	leaseContractEntity.setContractNumber(leaseContract.getContractNumber());
		leaseContractEntity.setMonthlyRent(amountRepository.save(AmountMapper.mapToAmountEntity(leaseContract.getMonthlyRent())));
		if(null != leaseContract.getCustomer() && null != leaseContract.getCustomer().getId()) {
			leaseContractEntity.setCustomer(customerRepository.findById(leaseContract.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + leaseContract.getCustomer().getId())));
		}
		if(null != leaseContract.getVehicle() && null != leaseContract.getVehicle().getId()) {
			leaseContractEntity.setVehicle(vehicleRepository.findById(leaseContract.getVehicle().getId())
					.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + leaseContract.getVehicle().getId())));
		}
		leaseContractRepository.save(leaseContractEntity);
        return ResponseEntity.ok(LeaseContractMapper.mapToRestLeaseContract(leaseContractEntity));
    }
}
