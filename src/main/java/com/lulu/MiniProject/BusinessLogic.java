package com.lulu.MiniProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class BusinessLogic {

	
		//CRUD Operations
		void createData() throws SQLException {
			Connection connection = ConnectDB.setupConnection();
			String query ="INSERT INTO products ( id, name, descp, cost ) VALUES( ?, ?,?, ?)";
//			String query = "insert values into employee(? ,? ,?)  ";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setInt(1, 453);
			myStmt.setString(2, "Bottle");
			myStmt.setString(3, "Stell");
			myStmt.setInt(4, 500);

	 

			int success = myStmt.executeUpdate();
			System.out.println("Added Successfully " + success);
	     	}

	 

		void readData() throws SQLException {

	 

	 

			Connection connection=ConnectDB.setupConnection();

	 

			 Statement statement;
			 statement = connection.createStatement();
	         ResultSet resultSet;
	         resultSet = statement.executeQuery("select * from products where id>=123");
	         int id;
	         String name;
	         String descp;
	         int cost;
	         while (resultSet.next()) {
	             id = resultSet.getInt("id");
	             name = resultSet.getString("name");
	             descp=resultSet.getString("descp");
	             cost=resultSet.getInt("cost");
	             System.out.println("id : " + id
	                                + " name : " + name + "  description: " + descp + " cost : " + cost);
	         }

	 

	 

	     //    "UPDATE your_table SET column1 = ?, column2 = ? WHERE condition_column = ?
		}

	 

		void updateData() throws SQLException {

	 

	 

			Connection connection = ConnectDB.setupConnection();
			String query = "update products set name= ? where id = ? ";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setString(1, "Airpods");
			myStmt.setInt(2, 345);
			boolean success = myStmt.execute();
			System.out.println(" Successfully " + success);

	 

	 

		}

	 

	 

		void deletData() throws SQLException {
			Connection connection = ConnectDB.setupConnection();
			String query = "delete from products where id = ? ";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setInt(1, 789);
			boolean success = myStmt.execute();
			System.out.println("Deleted Successfully " + success);

	 

	 

		}


		
	

}
