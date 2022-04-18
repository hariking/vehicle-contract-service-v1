package com.myapp.vehicle.contract.service.repository;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LEASE_CONTRACTS")
public class LeaseContract implements Serializable{
	private static final long serialVersionUID = LeaseContract.class.hashCode();

	private static final String LEASE_CONTRACTS_SEQ = "LEASE_CONTRACTS_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = LEASE_CONTRACTS_SEQ)
	@SequenceGenerator(name = LEASE_CONTRACTS_SEQ, sequenceName=LEASE_CONTRACTS_SEQ, allocationSize = 1)
	@Column(name = "ID", nullable=false)
	private Long id;

	@Column(name = "CONTRACT_NUMBER")
	private String contractNumber;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "RENT_REF_ID", referencedColumnName = "ID")
	private Amount monthlyRent;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID")
	private Vehicle vehicle;

	public LeaseContract() {}
	public LeaseContract(String contractNumber, Amount monthlyRent, Customer customer, Vehicle vehicle) {
		super();
		this.contractNumber = contractNumber;
		this.monthlyRent = monthlyRent;
		this.customer = customer;
		this.vehicle = vehicle;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public Amount getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(Amount monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
