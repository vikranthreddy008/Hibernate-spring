package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.exception.AccountException;
import com.lti.model.Account;

public class AccountDao {

	public Account fetchAccount(int aid) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql = "select * from account where aid = ?";
			pst  = conn.prepareStatement(sql);
			pst.setInt(1, aid);
			rs  = pst.executeQuery();

			if(rs.next()) {
				Account ob=new Account();
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setDateOfBirth(rs.getString(3));
				ob.setBalance(rs.getDouble(4));
				
				return ob;
			}
			throw new AccountException("No record found for account id " + aid);
	
		}
		catch(SQLException e) {
			throw new AccountException("Problem accessing the db", e);
		}
		catch(ClassNotFoundException e) {
			throw new AccountException("JDBC Driver not found", e);
		}
		finally {
			try { rs.close(); } catch (Exception e) {}
			try { pst.close(); } catch (Exception e) {}
			try { conn.close(); } catch (Exception e) {}
		}
	}

}
