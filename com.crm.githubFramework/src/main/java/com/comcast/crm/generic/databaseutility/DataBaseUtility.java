
package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class DataBaseUtility {
	Connection con;
	public void getDbConnection(String url , String username , String password) throws SQLException{
	try{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(url, username, password);
	} catch (Exception e) {	
	}
	}
	public void getDbConnection() throws SQLException{
	try{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	} catch (Exception e) {	
	}
}
	public void closeDbconnection() throws SQLException {
	try{
		con.close();
	}catch(Exception e) {
	}	
	}
	
	public  ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try{
			Statement stat=con.createStatement();
			result=stat.executeQuery(query);
		}catch (Exception e) {
	}
	return result;
}
	public  int executeNonSelectQuery(String query) {
		int result=0;
		try{
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
		}catch (Exception e) {
	}
	return result;
}
	public int getDataFromExcel(String string, int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}