package com.myapp.vehicle.contract.service.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AMOUNT")
public class Amount implements Serializable {

	private static final long serialVersionUID = Amount.class.hashCode();

	private static final String AMOUNT_SEQ = "AMOUNT_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = AMOUNT_SEQ)
	@SequenceGenerator(name = AMOUNT_SEQ, sequenceName = AMOUNT_SEQ, allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "NO_OF_DECIMALS")
	private Integer noOfDecimals;

	@Column(name = "CURRENCY")
	private String currency;

	public Amount() {}
	public Amount(String value, Integer noOfDecimals, String currency) {
		super();
		this.value = value;
		this.noOfDecimals = noOfDecimals;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNoOfDecimals() {
		return noOfDecimals;
	}

	public void setNoOfDecimals(Integer noOfDecimals) {
		this.noOfDecimals = noOfDecimals;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
}
