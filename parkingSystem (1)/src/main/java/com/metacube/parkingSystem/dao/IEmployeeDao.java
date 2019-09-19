package com.metacube.parkingSystem.dao;

import com.metacube.parkingSystem.model.PassDetailDB;
import com.metacube.parkingSystem.model.PassJoinVehicle;
import com.metacube.parkingSystem.model.PriceListDB;
import com.metacube.parkingSystem.model.VehicleDB;

import java.util.ArrayList;
import java.util.LinkedList;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDB;
import com.metacube.parkingSystem.model.FriendsDB;
import com.metacube.parkingSystem.model.Vehicle;

public interface IEmployeeDao {

	public boolean addEmployee(Employee e);
	public EmployeeDB getEmployeeDetail(String email, String password);
	public boolean addVehicle(Vehicle v);
	public ArrayList<VehicleDB> getVehicleDetail(int employeeId);
	public int getVehicleId(String vehicleNumber);
	public int getPriceListId(String planName, String vehicleType); 
	public ArrayList<PassJoinVehicle> getPassDetail(int employeeId);
	public String getImageName(int employeeId);
	public boolean addImage(int employeeId, String imageName);
	int getEmployeeId(String email);
	public ArrayList<PriceListDB> getPriceList(String vehicleType);
	boolean addPassDetail(PassDetailDB passDetailDB);
	EmployeeDB getEmployeeDetail(int employeeId);
	ArrayList<FriendsDB> getFriendsDetail(int employeeId);
	FriendsDB getFriendDetail(int friendId);
	boolean updateEmployee(Employee e, int employeeId);
	ArrayList<EmployeeDB> getCoworkerDetail(String organization);
}
