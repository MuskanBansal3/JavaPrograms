package com.ibm.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.ibm.training.bean.SpringBean;
import com.ibm.training.ui.App;

@Repository("daoclass")
public class SpringDaoClass implements SpringDaoInterface {
	
	DataSource datasource;
	NamedParameterJdbcTemplate namedParam;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;

		namedParam = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean insertData(SpringBean b) {
		String insertQuery = "insert into accountDetails values(:accountNumber, :holderName, :holderContactNumber, :accountBalance)";
		if(namedParam.update(insertQuery, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
				.addValue("holderName", b.getHolderName())
				.addValue("holderContactNumber", b.getHolderContactNumber())
				.addValue("accountBalance",b.getAccountBalance()))>0)
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean updateName(SpringBean b) {
		String queryNameUpdate = "update accountDetails set holdername = :holderName where accountNumber= :accountNumber";
		if(namedParam.update(queryNameUpdate, new MapSqlParameterSource("holderName",b.getHolderName())
				.addValue("accountNumber", b.getAccountNumber()))>0)
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean updateNumber(SpringBean b) {
		String queryNumberUpdate = "update accountDetails set holderContactNumber = :holderContactNumber where accountNumber= :accountNumber";
		if(namedParam.update(queryNumberUpdate, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber())
				.addValue("accountNumber", b.getAccountNumber()))>0)
			return true;
		else
			return false;
	}
	
	
	@Override
	public int getBalance(SpringBean b) {
		String queryGetBalance = " select accountBalance from accountDetails where holderContactNumber = :holderContactNumber";
		
		return namedParam.queryForObject(queryGetBalance, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class); 
	
	}
	
	public boolean checkBalance(SpringBean b) {
		String checkBalance = "select accountBalance from accountDetails where accountNumber = :accountNumber";
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		b.setAccountNumber(namedParam.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
		
		int balance = namedParam.queryForObject(checkBalance, new MapSqlParameterSource("accountNumber",b.getAccountNumber()), Integer.class);
		if(balance>b.getTransactionAmount())
			return true;
		else
			return false;
	}
	
	@Override
	public boolean depositInAccount(SpringBean b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (:accountNumber,:transactionAmount,:transactionTime)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance + :transactionAmount  WHERE accountNumber = :accountNumber";
	
		b.setAccountNumber(namedParam.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
		
		if(namedParam.update(queryUpdateAccountBalance, new MapSqlParameterSource("transactionAmount",b.getTransactionAmount())
																			.addValue("accountNumber", b.getAccountNumber()))>0)
			flag=flag+1;
		
		if(namedParam.update(queryDeposit, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
																.addValue("transactionAmount", b.getTransactionAmount())
																.addValue("transactionTime", b.getTransactionTime()))>0)
			flag=flag+1;
		
		if(flag==2)
			return true;
		else
			return false;
	}
	
	
	
	
	public boolean withdrawFromAccount(SpringBean b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (:accountNumber,:transactionAmount,:transactionTime)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance - :transactionAmount  WHERE accountNumber = :accountNumber";
		if(checkBalance(b)) {	
			b.setAccountNumber(namedParam.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
			if(namedParam.update(queryUpdateAccountBalance, new MapSqlParameterSource("transactionAmount",b.getTransactionAmount())
					.addValue("accountNumber", b.getAccountNumber()))>0)
				flag=flag+1;

			if(namedParam.update(queryDeposit, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
																		.addValue("transactionAmount", b.getTransactionAmount())
																		.addValue("transactionTime", b.getTransactionTime()))>0)
				flag=flag+1;

		}
		else
			System.out.println("low balance");
		
		if(flag==2)
			return true;
		else
			return false;
	}		
	
	public List<SpringBean> getTransaction(SpringBean b) {
		String queryGet = "select * from transactionDetails";
		return namedParam.query(queryGet, new TransactionMapper());
	
	}
	
	public List<SpringBean> getAllData(SpringBean b) {
		String queryGet = "select * from accountDetails";
		return namedParam.query(queryGet, new AccountMapper());
	}
	
	class TransactionMapper implements RowMapper<SpringBean>{
		
		@Override
		public SpringBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			SpringBean b = new SpringBean();
			b.setTransactionNumber(rs.getInt("transcationNumber"));
			b.setTransactionAmount(rs.getInt("transactionAmount"));
			b.setTransactionTime(rs.getDate("transactionTime"));
			b.setAccountNumber(rs.getInt("accountNumber"));
			return b;
		}
	}
	
	class AccountMapper implements RowMapper<SpringBean>{
		
		@Override
		public SpringBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			SpringBean b = new SpringBean();
			b.setAccountNumber(rs.getInt("accountNumber"));
			b.setHolderName(rs.getString("holderName"));
			b.setHolderContactNumber(rs.getDouble("holderContactNumber"));
			b.setAccountBalance(rs.getInt("accountBalance"));
			return b;
		}
	}
}
	