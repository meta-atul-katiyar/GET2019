//package com.metacube.parkingSystem.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.metacube.parkingSystem.model.PassType;
//
//public class PassTypeMapper implements RowMapper<PassType> {
//
//	@Override
//	public PassType mapRow(ResultSet resultSet, int arg1) throws SQLException {
//		PassType pass = new PassType();
//		pass.setDaily(resultSet.getFloat("daily"));
//		pass.setMonthly(resultSet.getFloat("monthly"));
//		pass.setYearly(resultSet.getFloat("yearly"));
//
//		return pass;
//	}
//
//}
