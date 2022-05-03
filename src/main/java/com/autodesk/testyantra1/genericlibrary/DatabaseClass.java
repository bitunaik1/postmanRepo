package com.autodesk.testyantra1.genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * Used to get and fetch the data from database
 * @author Omprakash
 *
 */
public class DatabaseClass {
	public Statement stat;
	public Connection conn;
	/**
	 * get the connection to database
	 * @throws SQLException 
	 */
public void getConnection() {
	try {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * create a statement 
 * @throws SQLException 
 */
public void createStatement()  {
	try {
		stat=conn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	ResultSet result;
  public ResultSet getAllData() {
	  String queryToFetch="select * from students_info";
	  try {
		result=stat.executeQuery(queryToFetch);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return result;
  }
  public boolean setData() {
	  int set=0;
	  boolean flag=false;
	  String queryToSet="input into students_info values('11','haha','hihi','k');";
	  try {
		set=stat.executeUpdate(queryToSet);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  if(set==1) {
			System.out.println("data has inserted");
			flag=true;
		}
	  else {
		  System.out.println("data not inserted");
	  }
	  return flag;
  }
  public void closeConnection() {
	  try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
