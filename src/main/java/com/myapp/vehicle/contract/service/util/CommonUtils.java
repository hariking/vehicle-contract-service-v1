package com.myapp.vehicle.contract.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonUtils {

	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	
	public static String getFormatedDate(Date birthDate) {
		return new SimpleDateFormat("dd-MM-yyyy").format(birthDate);
	}
	
	public static Date getParsedDate(String birthDate) {
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(birthDate);
		} catch (ParseException e) {
			logger.error("Unble to parse the privided date: {} ",()->birthDate);
		}
		return new Date();
	}
}
