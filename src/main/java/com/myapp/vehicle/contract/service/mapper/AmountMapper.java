package com.myapp.vehicle.contract.service.mapper;

import com.myapp.vehicle.contract.service.api.model.Amount;

public class AmountMapper {
	public static com.myapp.vehicle.contract.service.repository.Amount mapToAmountEntity(Amount amount) {
		com.myapp.vehicle.contract.service.repository.Amount amountEntity = new com.myapp.vehicle.contract.service.repository.Amount();
		amountEntity.setValue(amount.getValue());
		amountEntity.setNoOfDecimals(amount.getNoOfDecimals());
		amountEntity.setCurrency(amount.getCurrency());
		return amountEntity;
	}

	public static Amount mapToRestAmount(com.myapp.vehicle.contract.service.repository.Amount amountEntity) {
		Amount amount = new Amount().id(amountEntity.getId()).value(amountEntity.getValue())
				.noOfDecimals(amountEntity.getNoOfDecimals()).currency(amountEntity.getCurrency());
		return amount;
	}
	
}
