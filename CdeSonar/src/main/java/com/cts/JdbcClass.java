package com.cts;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class JdbcClass {
	
	Logger log=Logger.getLogger(JdbcClass.class);
	
	public void getDetails() {
	   
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		var loader=Thread.currentThread().getContextClassLoader();
		
		InputStream stream=loader.getResourceAsStream("db.properties");
		
		var prop=new Properties();
		try {
		prop.load(stream);
		
	
		
		Class.forName(prop.getProperty("driver"));
		
		conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		
		stmt=conn.createStatement();
		var id="545451";
		rs=stmt.executeQuery("select * from employee where id="+id+" or 1=1");
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
			log.info("some exception");
		}
		
		}catch(Exception e) {
			
			log.error("some exception");
			
		}finally {
			
			try {
		
				if(rs!=null) {	
				rs.close();
				}
		
		
				if(stmt!=null) {	
				stmt.close();
				}
			
			if(conn!=null) {	
			conn.close();
			}
			
			
			}catch(Exception e) {
				log.error("some exception");
			}
		}
		
	}

}
