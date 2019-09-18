package com.metacube.parkingSystem.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Vehicle {
	
	@NotBlank(message = "{blankVehicleName}")
	@Pattern(regexp="^[a-zA-Z0-9 ]{1,}", message = "{validVehicleName}")
	private String vehicleName;
	
	private String type;
	
	@NotBlank(message = "{blankVehicleNumber}")
	@Pattern(regexp="^[A-Z][A-Z]\\d\\d[A-Z][A-Z]\\d{4}$", message = "{validVehicleNumber}")
	private String vehicleNumber;
	
	private int employeeId;
	
	private String identification;
	
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
