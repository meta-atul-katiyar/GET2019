package com.metacube.parkingSystem.service.Implementation;

import java.util.ArrayList;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.IEmployeeDao;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDB;
import com.metacube.parkingSystem.model.FriendsDB;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.PassDetailDB;
import com.metacube.parkingSystem.model.PassJoinVehicle;
import com.metacube.parkingSystem.model.PriceListDB;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.model.VehicleDB;
import com.metacube.parkingSystem.service.IEmployeeSevice;

@Service
public class EmployeeServiceImp implements IEmployeeSevice{

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public boolean addEmployee(Employee e) {
		
		return employeeDao.addEmployee(e);
	}

	@Override
	public boolean addVehicle(Vehicle v) {
		return employeeDao.addVehicle(v);
	}
	
	@Override
	public int getPriceListId(String planName, String vehicleType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<PassJoinVehicle> getPassDetail(int employeeId) {
		return employeeDao.getPassDetail(employeeId);
	}

	@Override
	public String getImageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDB getEmployeeDetail(String email, String password) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeDetail(email, password);
	}

	@Override
	public int getEmployeeId(String email) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeId(email);
	}

	@Override
	public ArrayList<PriceListDB> getPriceList(String vehicleType) {
		return employeeDao.getPriceList(vehicleType);
	}

	@Override
	public ArrayList<VehicleDB> getVehicleDetail(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getVehicleDetail(employeeId);
	}

	@Override
	public int getVehicleId(String vehicleNumber) {
		
		return employeeDao.getVehicleId(vehicleNumber);
	}

	@Override
	public boolean addPassDetail(PassDetailDB passDetailDB) {
		return employeeDao.addPassDetail(passDetailDB);
	}

	@Override
	public EmployeeDB getEmployeeDetail(int employeeId) {
		return employeeDao.getEmployeeDetail(employeeId);
	}

	@Override
	public ArrayList<FriendsDB> getFriendsDetail(int employeeId) {
		return (ArrayList<FriendsDB>) employeeDao.getFriendsDetail(employeeId);
	}

	@Override
	public FriendsDB getFriendDetail(int friendId) {
		return employeeDao.getFriendDetail(friendId);
	}

	@Override
	public boolean updateEmployee(Employee e, int employeeId) {
		return employeeDao.updateEmployee(e, employeeId);
	}
	
	
}
