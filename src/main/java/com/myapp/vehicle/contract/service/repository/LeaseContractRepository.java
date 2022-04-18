package com.myapp.vehicle.contract.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseContractRepository extends JpaRepository<LeaseContract, Long>{

}
