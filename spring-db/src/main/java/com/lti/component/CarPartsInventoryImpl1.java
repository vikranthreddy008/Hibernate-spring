package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carParts1")

public class CarPartsInventoryImpl1 implements CarPartsInventory {

	public void addNewPart(CarPart carPart) {
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hrz");  
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


