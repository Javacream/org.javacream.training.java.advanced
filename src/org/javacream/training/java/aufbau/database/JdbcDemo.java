package org.javacream.training.java.aufbau.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args){
		
		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://10.28.4.1", "SA", "")){
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into audit values('Hello')");
			ResultSet rs = stmt.executeQuery("select * from audit");
			while(rs.next()) {
				String row = rs.getString(1);
				System.out.println(row);
			}
			Integer numberOfDeletedRows = stmt.executeUpdate("delete from audit");
			System.out.println(numberOfDeletedRows);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
