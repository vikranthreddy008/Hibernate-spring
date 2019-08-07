package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carParts2")

public class CarPartsInventoryImpl2 implements CarPartsInventory {

	@Autowired
	private DataSource dataSource;
	
	
	
	public void addNewPart(CarPart carPart) {
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {  
			
			conn = dataSource.getConnection();
			String sql="insert into TBL_CARPART values(?,?,?,?)";
          	pst=conn.prepareStatement(sql);
          	pst.setInt(1, carPart.getPartNo());
        	pst.setString(2, carPart.getName());			
        	pst.setString(3, carPart.getCarModel());
        	pst.setInt(4, carPart.getQuantity());
		    pst.executeUpdate();
		    
			 }
		
		catch(Exception e) {
			e.printStackTrace();
			
			}  
		
		finally {
			try { pst.close();} catch(Exception e) { }
			try { conn.close();} catch(Exception e) { }
			
			
		}
	}
		
		
		public List<CarPart> getAvailableParts() {
		
		return null;
	}
}


