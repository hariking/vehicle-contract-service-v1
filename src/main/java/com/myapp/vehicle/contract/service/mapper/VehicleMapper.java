package com.myapp.vehicle.contract.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.myapp.vehicle.contract.service.api.model.Vehicle;
import com.myapp.vehicle.contract.service.repository.Amount;

public class VehicleMapper {

	public static List<Vehicle> mapToRestVehicles(List<com.myapp.vehicle.contract.service.repository.Vehicle> vehicleEntites){
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleEntites.forEach(vehicleEntity -> {
			Vehicle Vehicle = mapToRestVehicle(vehicleEntity);
			vehicles.add(Vehicle);
			
		});
		return vehicles;
	}

	public static Vehicle mapToRestVehicle(com.myapp.vehicle.contract.service.repository.Vehicle vehicleEntity) {
		Vehicle Vehicle = new Vehicle().id(vehicleEntity.getId()).brand(vehicleEntity.getBrand()).model(vehicleEntity.getModel())
				.modelYear(vehicleEntity.getModelYear())
				.identificationNumber(vehicleEntity.getIdentificationNumber()).price(AmountMapper.mapToRestAmount(vehicleEntity.getPrice()));
		return Vehicle;
	}
	
	public static com.myapp.vehicle.contract.service.repository.Vehicle mapToVehicleEntity(Vehicle vehicle, Amount price){
		com.myapp.vehicle.contract.service.repository.Vehicle vehicleEntity = new com.myapp.vehicle.contract.service.repository.Vehicle();
		vehicleEntity.setBrand(vehicle.getBrand());
		vehicleEntity.setModel(vehicle.getModel());
		vehicleEntity.setModelYear(vehicle.getModelYear());
		vehicleEntity.setIdentificationNumber(vehicle.getIdentificationNumber());
		vehicleEntity.setPrice(price);
		return vehicleEntity;
	}
}
