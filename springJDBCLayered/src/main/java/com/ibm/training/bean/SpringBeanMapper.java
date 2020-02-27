package com.ibm.training.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpringBeanMapper implements RowMapper<SpringBean> {

	public SpringBean mapRow(ResultSet resultSet, int i) throws SQLException {

		SpringBean sb = new SpringBean();
		sb.setException(resultSet.getString("exception"));
		sb.setAccountBalance(resultSet.getInt("accountBalance"));
		sb.setHolderName(resultSet.getString("holderName"));
		sb.setHolderContactNumber(resultSet.getDouble("holderContactNumber"));
		sb.setAccountNumber(resultSet.getInt("accountNumber"));
		sb.setTransactionNumber(resultSet.getInt("transactionNumber"));
		sb.setTransactionAmount(resultSet.getInt("transactionAmount"));
		sb.setTransactionTime(resultSet.getDate("transactionTime"));
		
	
		return sb;
	}
}