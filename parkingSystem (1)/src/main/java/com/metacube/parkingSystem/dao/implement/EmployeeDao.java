package com.metacube.parkingSystem.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.IEmployeeDao;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDB;
import com.metacube.parkingSystem.model.FriendsDB;
import com.metacube.parkingSystem.model.PassDetailDB;
import com.metacube.parkingSystem.model.PassJoinVehicle;
import com.metacube.parkingSystem.model.PriceListDB;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.model.VehicleDB;

@Repository
public class EmployeeDao implements IEmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao(DataSource dataSource) {
		System.out.println("connection....");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public boolean addEmployee(Employee e) {
		String query="INSERT INTO `ead-9`.`employee_detail` (`fullName`, `gender`, `email`, `password`, `contactNumber`, `organization`) VALUES ("
			    +"'"+e.getFullName()+"','"+e.getGender()+"','"+e.getEmail()+"','"+e.getPassword()+"','"
			    +e.getContactNumber()+"','"+e.getOrganization()+"')";  
			   return jdbcTemplate.update(query)>0;  
	}
	
	@Override
	public boolean updateEmployee(Employee e, int employeeId) {
		String query="UPDATE  `ead-9`.`employee_detail` "
				+ "SET `fullName`='"+e.getFullName()+"', `gender`='"+e.getGender()+"',"
				+ " `contactNumber`='" +e.getContactNumber()+"',"
				+ " `organization`='"+e.getOrganization()+"'"
				+ "WHERE ID="+employeeId;
			   return jdbcTemplate.update(query)>0;  
	}

	@Override
	public EmployeeDB getEmployeeDetail(String email, String password) {
		String query = "SELECT * FROM `ead-9`.`employee_detail` AS ED WHERE "
				+ "ED.email ='"+email+"' AND ED.password = '"+password+"'";
		return (EmployeeDB) jdbcTemplate.queryForObject(query, new RowMapper<EmployeeDB>() {
			 @Override  
			    public EmployeeDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				 EmployeeDB e=new EmployeeDB();  
			        e.setID(rs.getInt(1));  
			        e.setFullName(rs.getString(2));  
			        e.setGender(rs.getString(3)); 
			        e.setEmail(rs.getString(4));
			        e.setContactNumber(rs.getString(6));
			        e.setOrganization(rs.getString(7));
			       
			        return e;  
			    }  
		});
	}
	
	@Override
	public EmployeeDB getEmployeeDetail(int employeeId) {
		String query = "SELECT * FROM `ead-9`.`employee_detail` AS ED WHERE "
				+ "ED.ID ="+employeeId;
		return (EmployeeDB) jdbcTemplate.queryForObject(query, new RowMapper<EmployeeDB>() {
			 @Override  
			    public EmployeeDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				 EmployeeDB e=new EmployeeDB();  
			        e.setID(rs.getInt(1));  
			        e.setFullName(rs.getString(2));  
			        e.setGender(rs.getString(3)); 
			        e.setEmail(rs.getString(4));
			        e.setContactNumber(rs.getString(6));
			        e.setOrganization(rs.getString(7));
			       
			        return e;  
			    }  
		});
	}
	
	@Override
	public  ArrayList<FriendsDB> getFriendsDetail(int employeeId) {
		String query = "SELECT * FROM `ead-9`.`friends_list` AS FL WHERE "
				+ "FL.userId ="+employeeId;
		return (ArrayList<FriendsDB>) jdbcTemplate.query(query, new RowMapper<FriendsDB>() {
			 @Override  
			    public FriendsDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				 FriendsDB e=new FriendsDB();  
			        e.setID(rs.getInt(1));  
  
			        e.setGender(rs.getString(3)); 
			        e.setFriendName(rs.getString(4));
			        e.setImageName(rs.getString(5));
			        e.setAddress(rs.getString(6));
			        e.setContactNumber(rs.getString(7));
			        
			       
			        return e;  
			    }  
		});
	}

	@Override
	public  FriendsDB getFriendDetail(int friendId) {
		String query = "SELECT * FROM `ead-9`.`friends_list` AS FL WHERE "
				+ "FL.ID ="+friendId;
		return (FriendsDB) jdbcTemplate.queryForObject(query, new RowMapper<FriendsDB>() {
			 @Override  
			    public FriendsDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				 FriendsDB e=new FriendsDB();  
			        e.setID(rs.getInt(1));  
  
			        e.setGender(rs.getString(3)); 
			        e.setFriendName(rs.getString(4));
			        e.setImageName(rs.getString(5));
			        e.setAddress(rs.getString(6));
			        e.setContactNumber(rs.getString(7));
			        
			       
			        return e;  
			    }  
		});
	}
	
	@Override
	public int getPriceListId(String planName, String vehicleType) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean addPassDetail(PassDetailDB passDetailDB) {
		String query="INSERT INTO `ead-9`.`pass_details` (`priceListId`, `generationTime`, `vehicleId`) VALUES("
				+passDetailDB.getPriceListId()+", now(), "+passDetailDB.getVehicleId()+");";
		return jdbcTemplate.update(query)>0;
	}

	@Override
	public ArrayList<PassJoinVehicle> getPassDetail(int employeeId) {
		String query = "SELECT * FROM   (vehicle_detail AS VD inner join pass_details AS PD ON VD.ID=PD.vehicleId) " 
				+" inner join price_list AS PL ON PL.ID=PD.priceListId "
				+" WHERE VD.employeeId="+employeeId;
		return (ArrayList<PassJoinVehicle>) jdbcTemplate.query(query, new RowMapper<PassJoinVehicle>() {
			 @Override  
			    public PassJoinVehicle mapRow(ResultSet rs, int rownumber) throws SQLException {  
				 PassJoinVehicle e=new PassJoinVehicle();  
			        e.setID(rs.getInt(1));  
			        e.setPriceListId(rs.getInt(8));  
			        e.setGenerationTime(rs.getDate(9)); 
			        e.setVehicleName(rs.getString(2));
			        e.setType(rs.getString(3));
			        e.setVehicleNumber(rs.getString(4));
			        e.setIdentification(rs.getString(6));
			        e.setPlanName(rs.getString(13));
			        e.setPrice(rs.getDouble(14));
			        return e;  
			    }  
		});
	}

	@Override
	public String getImageName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addVehicle(Vehicle v) {
		String query="INSERT INTO `ead-9`.`vehicle_detail` (`vehicleName`, `type`, "
				+ "`vehicleNumber`, `employeeId`, `identification`) VALUES ('"
				+v.getVehicleName()+"','"+v.getType()+"','"+v.getVehicleNumber()+"',"+v.getEmployeeId()
				+",'"+v.getIdentification()+"')";
		return jdbcTemplate.update(query)>0;
	}


	@Override
	public int getEmployeeId(String email) {
		String query = "SELECT ED.ID FROM employee_detail AS ED WHERE "
				+"ED.email = '"+email+"';";
		return jdbcTemplate.queryForObject(query, int.class);
	}


	@Override
	public ArrayList<PriceListDB> getPriceList(String vehicleType) {
		String query = "SELECT * FROM price_list AS PL WHERE PL.vehicleType = '"
				+ vehicleType+"';";

		return (ArrayList<PriceListDB>) jdbcTemplate.query(query, new RowMapper<PriceListDB>() {
			  @Override  
			    public PriceListDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				  PriceListDB e=new PriceListDB();  
			        e.setID(rs.getInt(1));  
			        e.setVehicleType(rs.getString(2));  
			        e.setPlanName(rs.getString(3)); 
			        e.setPrice(rs.getDouble(4));
			        return e;  
			    }  
		});  
	}


	@Override
	public ArrayList<VehicleDB> getVehicleDetail(int employeeId) {
		String query = "SELECT * FROM vehicle_detail AS VD WHERE VD.employeeId="
				+employeeId;
		return (ArrayList<VehicleDB>) jdbcTemplate.query(query, new RowMapper<VehicleDB>() {
			  @Override  
			    public VehicleDB mapRow(ResultSet rs, int rownumber) throws SQLException {  
				  VehicleDB e=new VehicleDB();  
			        e.setID(rs.getInt(1));  
			        e.setVehicleName(rs.getString(2));  
			        e.setType(rs.getString(3)); 
			        e.setVehicleNumber(rs.getString(4));
			        e.setEmployeeId(rs.getInt(5));
			        e.setIdentification(rs.getString(6));
			        return e;  
			    }  
		});
	}

	@Override
	public int getVehicleId(String vehicleNumber) {
		String query = "SELECT VD.ID FROM vehicle_detail AS VD WHERE VD.vehicleNumber='"
				+ vehicleNumber+"';";
		return jdbcTemplate.queryForObject(query, int.class);
	}
	

}
