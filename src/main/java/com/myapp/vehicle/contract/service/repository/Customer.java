package com.myapp.vehicle.contract.service.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.myapp.vehicle.contract.service.util.CommonUtils;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {

	private static final long serialVersionUID = Customer.class.hashCode();

	private static final String CUSTOMERS_SEQ = "CUSTOMERS_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMERS_SEQ)
	@SequenceGenerator(name = CUSTOMERS_SEQ, sequenceName = CUSTOMERS_SEQ, allocationSize = 1)
	@Column(name = "ID", nullable=false)
	private long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = CommonUtils.getParsedDate(birthDate);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return CommonUtils.getFormatedDate(this.birthDate);
	}
	public void setBirthDate(String birthDate) {
		this.birthDate =  CommonUtils.getParsedDate(birthDate);
	}
	

}
