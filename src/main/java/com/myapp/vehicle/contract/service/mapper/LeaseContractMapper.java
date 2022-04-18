package com.myapp.vehicle.contract.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.myapp.vehicle.contract.service.api.model.LeaseContract;
import com.myapp.vehicle.contract.service.repository.Amount;

public class LeaseContractMapper {

	public static List<LeaseContract> mapToRestLeaseContracts(List<com.myapp.vehicle.contract.service.repository.LeaseContract> leaseContractEntities){
		List<LeaseContract> leaseContracts = new ArrayList<>();
		leaseContractEntities.forEach(leaseContractEntity -> {
			LeaseContract leaseContract = mapToRestLeaseContract(leaseContractEntity);
			leaseContracts.add(leaseContract);
		});
		return leaseContracts;
	}

	public static LeaseContract mapToRestLeaseContract(
			com.myapp.vehicle.contract.service.repository.LeaseContract leaseContractEntity) {
		LeaseContract leaseContract =new LeaseContract().id(leaseContractEntity.getId()).contractNumber(leaseContractEntity.getContractNumber()).monthlyRent(AmountMapper.mapToRestAmount(leaseContractEntity.getMonthlyRent()))
				.customer(CustomerMapper.mapToRestCustomer(leaseContractEntity.getCustomer()))
				.vehicle(VehicleMapper.mapToRestVehicle(leaseContractEntity.getVehicle()));
		return leaseContract;
	} 
	
	public static com.myapp.vehicle.contract.service.repository.LeaseContract mapToLeaseContractEntity(LeaseContract leaseContract, Amount monthlyRent){
		com.myapp.vehicle.contract.service.repository.LeaseContract leaseContractEntity = new com.myapp.vehicle.contract.service.repository.LeaseContract();
		leaseContractEntity.setContractNumber(leaseContract.getContractNumber());
		leaseContractEntity.setMonthlyRent(monthlyRent);
		return leaseContractEntity;
	}
}
