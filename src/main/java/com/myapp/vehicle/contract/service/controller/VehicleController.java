package com.myapp.vehicle.contract.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.vehicle.contract.service.api.VehiclesApi;
import com.myapp.vehicle.contract.service.api.model.Vehicle;
import com.myapp.vehicle.contract.service.exception.ResourceNotFoundException;
import com.myapp.vehicle.contract.service.mapper.AmountMapper;
import com.myapp.vehicle.contract.service.mapper.VehicleMapper;
import com.myapp.vehicle.contract.service.repository.Amount;
import com.myapp.vehicle.contract.service.repository.AmountRepository;
import com.myapp.vehicle.contract.service.repository.VehicleRepository;

@RestController
public class VehicleController implements VehiclesApi {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private AmountRepository amountRepository;

	@Override
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return ResponseEntity.ok(VehicleMapper.mapToRestVehicles(vehicleRepository.findAll()));
	}

	@Override
	public ResponseEntity<Vehicle> getVehicleById(Long id) {
		com.myapp.vehicle.contract.service.repository.Vehicle vehicleEntity = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		return ResponseEntity.ok(VehicleMapper.mapToRestVehicle(vehicleEntity));

	}

	@Override
	public ResponseEntity<Vehicle> addVehicle(Vehicle vehicle) {
		Amount priceEntity =amountRepository.save(AmountMapper.mapToAmountEntity(vehicle.getPrice()));
		com.myapp.vehicle.contract.service.repository.Vehicle vehicleEntity = VehicleMapper.mapToVehicleEntity(vehicle, priceEntity);
		vehicleRepository.save(vehicleEntity);
		return ResponseEntity.ok(VehicleMapper.mapToRestVehicle(vehicleEntity));
	}

	@Override
	public ResponseEntity<Vehicle> updateVehicleDeatilsById(Long id, Vehicle vehicle) {
		com.myapp.vehicle.contract.service.repository.Vehicle vehicleEntity = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		vehicleEntity.setBrand(vehicle.getBrand());
		vehicleEntity.setModel(vehicle.getModel());
		vehicleEntity.setModelYear(vehicle.getModelYear());
		vehicleEntity.setIdentificationNumber(vehicle.getIdentificationNumber());
		vehicleEntity.setPrice(amountRepository.save(AmountMapper.mapToAmountEntity(vehicle.getPrice())));
		vehicleRepository.save(vehicleEntity);
		return ResponseEntity.ok(VehicleMapper.mapToRestVehicle(vehicleEntity));
	}
}
