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
@Table(name = "VEHICLES")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = Customer.class.hashCode();

	private static final String VEHICLES_SEQ = "VEHICLES_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = VEHICLES_SEQ)
	@SequenceGenerator(name = VEHICLES_SEQ, sequenceName=VEHICLES_SEQ, allocationSize = 1)
	@Column(name = "ID", nullable=false)
	private long id;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "MODEL_YEAR")
	private String modelYear;

	@Column(name = "IDENTIFICATION_NUMBER")
	private String identificationNumber;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "PRICE_REF_ID", referencedColumnName = "ID")
	private Amount price;

	public Vehicle() {}
	public Vehicle(String brand, String model, String modelYear, String identificationNumber, Amount price) {
		super();
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.identificationNumber = identificationNumber;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Amount getPrice() {
		return price;
	}

	public void setPrice(Amount price) {
		this.price = price;
	}
	
	
}
